package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.utils.MessageStringResponse;
import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.FriendRequest;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
import com.huuluc.englearn.model.response.MainUserInfoResponse;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.FriendRequestRepository;
import com.huuluc.englearn.service.FriendRequestService;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestServiceImpl implements FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UserService userService;

    @Override
    public ResponseEntity<ResponseModel> findByUserSender(String sender) throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        List<FriendRequest> list = friendRequestRepository.findByUserSender(sender);

        //get list user with username in list
        List<MainUserInfoResponse> userInfoResponses = new ArrayList<>();
        for (FriendRequest friendRequest : list) {
            ResponseModel responseModel = userService.getByUsername(friendRequest.getSender()).getBody();

            //check if response model is null
            if (responseModel == null) {
                continue;
            }
            MainUserInfoResponse user = (MainUserInfoResponse) responseModel.getData();
            userInfoResponses.add(user);
        }
        return new ResponseEntity<>(new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_LIST_FRIEND_SUCCESSFULLY, userInfoResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> findByUserReceiver(String receiver) throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        List<FriendRequest> list = friendRequestRepository.findByUserReceiver(receiver);

        //get list user with username in list
        List<MainUserInfoResponse> userInfoResponses = new ArrayList<>();
        for (FriendRequest friendRequest : list) {
            ResponseModel responseModel = userService.getByUsername(friendRequest.getSender()).getBody();

            //check if response model is null
            if (responseModel == null) {
                continue;
            }

            MainUserInfoResponse user = (MainUserInfoResponse) responseModel.getData();
            userInfoResponses.add(user);
        }
        return new ResponseEntity<>(new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_LIST_FRIEND_SUCCESSFULLY, userInfoResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getListFriend(String username) throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        List<FriendRequest> list = friendRequestRepository.getListFriendRequest(username);

        //get list user with username in list
        List<MainUserInfoResponse> userInfoResponses = new ArrayList<>();
        for (FriendRequest friendRequest : list) {
            //get friend username
            String friendUsername = friendRequest.getSender().equals(username) ?
                    friendRequest.getReceiver() : friendRequest.getSender();

            ResponseModel responseModel = userService.getByUsername(friendUsername).getBody();

            if (responseModel == null) {
                continue;
            }

            MainUserInfoResponse user = (MainUserInfoResponse) responseModel.getData();

            userInfoResponses.add(user);
        }
        return new ResponseEntity<>(new ResponseModel(MessageStringResponse.SUCCESS,
                MessageStringResponse.GET_LIST_FRIEND_SUCCESSFULLY, userInfoResponses), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> insertFriendRequest(FriendRequiredRequest request)
            throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        FriendRequest friendRequest = new FriendRequest(sender, receiver, (short) 0);
        int result = friendRequestRepository.insertFriendRequest(friendRequest);

        if (result == 1) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(MessageStringResponse.SUCCESS);
            responseModel.setData(null);
            responseModel.setMessage("Send friend request successfully");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }
        throw new FriendRequestException("Send friend request failed");
    }

    @Override
    public ResponseEntity<ResponseModel> acceptFriendRequest(FriendRequiredRequest request)
            throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        int result = friendRequestRepository.acceptFriendRequest(sender, receiver);

        if (result == 0) {
            throw new FriendRequestException("Accept friend request failed");
        }

        ResponseModel responseModel = new ResponseModel();
        responseModel.setStatus(MessageStringResponse.SUCCESS);
        responseModel.setData(null);
        responseModel.setMessage("Send friend request successfully");
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> deleteFriendRequest(FriendRequiredRequest request)
            throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        int result = friendRequestRepository.deleteFriendRequest(sender, receiver);

        if (result == 0) {
            throw new FriendRequestException("Delete friend request failed");
        }

        //check if result is MessageStringResponse.SUCCESS
        if (result == 1) {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setStatus(MessageStringResponse.SUCCESS);
            responseModel.setData(null);
            responseModel.setMessage("Delete friend request successfully");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }
        throw new FriendRequestException("Delete friend request failed");
    }

}
