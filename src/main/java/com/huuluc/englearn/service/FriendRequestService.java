package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.FriendRequest;
import com.huuluc.englearn.model.request.FriendRequiredRequest;

import java.util.List;

public interface FriendRequestService {
    List<FriendRequest> findByUserSender(String sender) throws FriendRequestException;
    List<FriendRequest> findByUserReceiver(String receiver) throws FriendRequestException;
    List<FriendRequest> getListFriend(String username) throws FriendRequestException;

    int insertFriendRequest(FriendRequiredRequest request) throws FriendRequestException;

    int acceptFriendRequest(FriendRequiredRequest request) throws FriendRequestException;

    int deleteFriendRequest(FriendRequiredRequest request) throws FriendRequestException;
}
