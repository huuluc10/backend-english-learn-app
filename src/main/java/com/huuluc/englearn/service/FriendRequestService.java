package com.huuluc.englearn.service;

import com.huuluc.englearn.model.FriendRequest;

import java.util.List;

public interface FriendRequestService {
    List<FriendRequest> findByUserSender(String sender);

    int insertFriendRequest(String sender, String receiver);

    int acceptFriendRequest(String sender, String receiver);

    int deleteFriendRequest(String sender, String receiver);
}
