package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.FriendRequest;
import com.huuluc.englearn.repository.FriendRequestRepository;
import com.huuluc.englearn.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestServiceImpl implements FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;

    @Override
    public List<FriendRequest> findByUserSender(String sender) {
        return friendRequestRepository.findByUserSender(sender);
    }

    @Override
    public int insertFriendRequest(String sender, String receiver) {
        FriendRequest friendRequest = new FriendRequest(sender, receiver, (short) 1);
        return friendRequestRepository.insertFriendRequest(friendRequest);
    }

    @Override
    public int acceptFriendRequest(String sender, String receiver) {
        return friendRequestRepository.acceptFriendRequest(sender, receiver);
    }

    @Override
    public int deleteFriendRequest(String sender, String receiver) {
        return friendRequestRepository.deleteFriendRequest(sender, receiver);
    }
}
