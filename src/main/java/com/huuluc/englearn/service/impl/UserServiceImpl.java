package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.Level;
import com.huuluc.englearn.model.Media;
import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.model.response.UserInfoResponse;
import com.huuluc.englearn.repository.RoleRepository;
import com.huuluc.englearn.repository.UserRepository;
import com.huuluc.englearn.service.LevelService;
import com.huuluc.englearn.service.MediaService;
import com.huuluc.englearn.service.StorageService;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MediaService mediaService;
    private final LevelService levelService;
    private final StorageService storageService;

    @Override
    public ResponseEntity<ResponseModel> getByUsername(String username) throws IOException {
        ResponseModel responseModel;

        User user = userRepository.getByUsername(username);

        // Check if the user is found
        if (user != null) { // If user is found
            // Get url avatar
            Media media = mediaService.getById(user.getAvatar());
            String avatarUrl = media.getUrl();

            // Get Level
            Level level = levelService.findByExp(user.getExperience());

            UserInfoResponse userInfoResponse = new UserInfoResponse(user);
            userInfoResponse.setUrlAvatar(avatarUrl);
            userInfoResponse.setLevel(level.getLevelName());

            responseModel = new ResponseModel("success", "User found", userInfoResponse);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } else { // If user is not found
            responseModel = new ResponseModel("error", "User not found", null);
            return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public UserDetails getByUsernameAndPassword(String username, String password) {
        User user = userRepository.getByUsername(username);
        Role role = roleRepository.getByRoleId(user.getRoleId());
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(role.getName())
                .build();
    }

    @Override
    public ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException {
        // Create a new user object
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(null);
        user.setRoleId((short) 1);
        user.setStreak(0);
        user.setAvatar(1);
        user.setExperience(0);

        ResponseModel responseModel;

        // Check if the response is successful
        if (userRepository.insertUser(user) == 1) { // If user is created successfully
           responseModel = new ResponseModel("success", "User created successfully", null);
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        } else {  // If user is not created successfully
            responseModel = new ResponseModel("error", "User creation failed", null);
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public int deleteUser(String username) {
        return userRepository.deleteUser(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
