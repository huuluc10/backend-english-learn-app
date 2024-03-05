package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FriendRequestService {
    ResponseEntity<ResponseModel> findByUserSender(String sender) throws FriendRequestException, IOException;
    ResponseEntity<ResponseModel> findByUserReceiver(String receiver) throws FriendRequestException, IOException;
    ResponseEntity<ResponseModel> getListFriend(String username) throws FriendRequestException, IOException;

    ResponseEntity<ResponseModel> insertFriendRequest(FriendRequiredRequest request) throws FriendRequestException;

    ResponseEntity<ResponseModel> acceptFriendRequest(FriendRequiredRequest request) throws FriendRequestException;

    ResponseEntity<ResponseModel> deleteFriendRequest(FriendRequiredRequest request) throws FriendRequestException;
}
