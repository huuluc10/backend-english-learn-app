package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.FriendRequest;
import com.huuluc.englearn.repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;

    public List<FriendRequest> findByUserSender(String sender) {
        return friendRequestRepository.findByUserSender(sender);
    }

    public int insertFriendRequest(String sender, String receiver) {
        FriendRequest friendRequest = new FriendRequest(sender, receiver, (short) 1);
        return friendRequestRepository.insertFriendRequest(friendRequest);
    }

    public int acceptFriendRequest(String sender, String receiver) {
        return friendRequestRepository.acceptFriendRequest(sender, receiver);
    }

    public int deleteFriendRequest(String sender, String receiver) {
        return friendRequestRepository.deleteFriendRequest(sender, receiver);
    }
}
