package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.request.*;
import com.huuluc.englearn.utils.MessageStringResponse;
import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.model.response.UserInfoResponse;
import com.huuluc.englearn.repository.UserMissionRepository;
import com.huuluc.englearn.repository.UserRepository;
import com.huuluc.englearn.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MediaService mediaService;
    private final LevelService levelService;
    private final StorageService storageService;
    private final UserMissionService userMissionService;
    private final UserMissionRepository userMissionRepository;

    // Update streak of user if user has not completed the mission of the last day
    private int updateStreak(User user) throws UserMissionException, UserException {
        if (userMissionService.checkActiveMissionLastDay(user.getUsername()) == 0) {
            int result = userRepository.updateStreak(user.getUsername(), 0);

            if (result == 0) {
                throw new UserException(MessageStringResponse.UPDATE_STREAK_FAILED);
            }
            return result;
        }
        return 1;
    }

    // Increase the streak of user
    public int increaseStreak(String username) throws UserException, UserMissionException {
        if (userMissionRepository.checkActiveMissionToday(username) == 0) {
            User user = userRepository.getByUsername(username);
            int streak = user.getStreak();
            return userRepository.updateStreak(username, streak + 1);
        }
        return 1;
    }


    @Override
    public ResponseEntity<ResponseModel> getByUsername(String username) throws UserException, LevelException, MediaException, UserMissionException {
        ResponseModel responseModel;

        User user = userRepository.getByUsername(username);

        if (updateStreak(user) == 0) {
            throw new UserException(MessageStringResponse.UPDATE_STREAK_FAILED);
        }

        // Get url avatar
        ResponseModel responseModelAvatar = mediaService.getById(user.getAvatar()).getBody();
        Media media;

        if (responseModelAvatar == null) {
            throw new MediaException(MessageStringResponse.DATA_NOT_FOUND);
        } else {
            media = (Media) responseModelAvatar.getData();
        }
        String avatarUrl = media.getUrl();

        // Get Level
        ResponseModel responseModelLevel = levelService.findByExp(user.getExperience()).getBody();

        if (responseModelLevel == null) {
            throw new LevelException(MessageStringResponse.DATA_NOT_FOUND);
        }
        Level level = (Level) responseModelLevel.getData();

        UserInfoResponse userInfoResponse = new UserInfoResponse(user);
        userInfoResponse.setUrlAvatar(avatarUrl);
        userInfoResponse.setLevel(level.getLevelName());

        responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_USER_SUCCESSFULLY, userInfoResponse);
        return ResponseEntity.ok(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> createUser(SignupRequest request) throws UserException {
        // Create a new user object
        User user = createObjectUser(request);

        ResponseModel responseModel;

        // Check if the response is successful
        if (userRepository.insertUser(user) == 1) { // If user is created successfully
           responseModel = new ResponseModel(MessageStringResponse.SUCCESS, MessageStringResponse.SIGNUP_SUCCESSFULLY, null);
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        } else {  // If user is not created successfully
            throw new UserException(MessageStringResponse.SIGNUP_FAILED);
        }
    }

    private static User createObjectUser(SignupRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setGender(request.isGender());
        user.setFullName(request.getFullName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(null);
        user.setRoleId((short) 2);
        user.setStreak(0);
        user.setExperience(0);

        if (user.isGender()) { // If user is male
            user.setAvatar((short) 2);
        } else { // If user is female
            user.setAvatar((short) 3);
        }
        return user;
    }

    @Override
    public ResponseEntity<ResponseModel> updateUser(UpdateInfoRequest request) throws UserException {
        if (userRepository.updateUser(request) == 1) { // If user is updated successfully
            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.UPDATE_INFO_SUCCESSFULLY, null);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            throw new UserException(MessageStringResponse.UPDATE_INFO_FAILED);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> findAll() throws UserException {
        List<User> userList = userRepository.findAll();

        if (userList != null) {
            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.GET_LIST_FRIEND_SUCCESSFULLY, userList);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            throw new UserException(MessageStringResponse.DATA_NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> updateAvatar(String username, MultipartFile avatar) throws UserException, StorageException, MediaException {

        //check avatar is image extension
        if (avatar.isEmpty()) {
            throw new StorageException(MessageStringResponse.FILE_IS_EMPTY);
        }
        String contentType = avatar.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new StorageException(MessageStringResponse.FILE_IS_NOT_SUPPORTED);
        }

        // replace the file name with the username and extension no change
        String fileName = username + ".png";
        // store the file in the storage
        String url = storageService.store(avatar, "images/avatars/", fileName);

        if (url != null) {
            String mediaName = "Avatar + " + username;

            // insert the new media
            Media media = new Media();
            media.setMediaTypeId((short) 1);
            media.setMediaName(mediaName);
            media.setUrl(url);

            // check if the media is already in the database
            if (mediaService.getByName(mediaName) == null) {
                int resultSave =  mediaService.save(media);

                //check save media success
                if (resultSave == 0) {
                    throw new MediaException(MessageStringResponse.SAVE_MEDIA_FAILED);
                } else {
                    // update the user avatar
                    Media newMedia = mediaService.getByName(mediaName);
                    int resultUpdate = userRepository.updateAvatar(username, newMedia.getMediaId());

                    //check update avatar success
                    if (resultUpdate == 0) {
                        throw new UserException(MessageStringResponse.UPDATE_AVATAR_FAILED);
                    }
                }
            }


            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.UPDATE_AVATAR_SUCCESSFULLY, null);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            throw new StorageException(MessageStringResponse.UPDATE_AVATAR_FAILED);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> changePassword(ChangePasswordRequest request) throws UserException, SQLIntegrityConstraintViolationException {
        //get password of user
        User user = userRepository.getByUsername(request.getUsername());
        String password = user.getPassword();

        //check old password is equal with password of user
        if (password.equals(request.getOldPassword())) {
            if (userRepository.changePassword(request) == 1) { // If password is changed successfully
                ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                        MessageStringResponse.CHANGE_PASSWORD_SUCCESSFULLY, null);
                return new ResponseEntity<>(responseModel, HttpStatus.OK);
            } else {
                throw new UserException(MessageStringResponse.CHANGE_PASSWORD_FAILED);
            }
        } else {    // If old password is incorrect
            throw new UserException(MessageStringResponse.OLD_PASSWORD_INCORRECT);
        }
    }

    @Override
    public boolean existsByUsername(String username) throws UserException {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) throws UserException {
        return userRepository.existsByEmail(email);
    }

    @Override
    public ResponseEntity<ResponseModel> addEmail(AddEmailRequest request) throws UserException {
        User user = userRepository.getByUsername(request.getUsername());
        if (user == null) {
            throw new UserException(MessageStringResponse.GET_USER_NOT_FOUND);
        }

        int result = userRepository.addEmail(request);

        if (result == 1) {
            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.ADD_EMAIL_SUCCESSFULLY, null);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            throw new UserException(MessageStringResponse.ADD_EMAIL_FAILED);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> resetPassword(ResetPasswordRequest request) throws UserException {
        User user = userRepository.getByUsername(request.getUsername());
        if (user == null) {
            throw new UserException(MessageStringResponse.GET_USER_NOT_FOUND);
        }

        int result = userRepository.resetPassword(request);

        if (result == 1) {
            ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                    MessageStringResponse.CHANGE_PASSWORD_SUCCESSFULLY, null);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else {
            throw new UserException(MessageStringResponse.CHANGE_PASSWORD_FAILED);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> getStreak(String username) throws UserException {
        ResponseModel responseModel = new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_STREAK_SUCCESSFULLY, userRepository.getStreak(username));
        return ResponseEntity.ok(responseModel);
    }
}
