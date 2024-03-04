package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.FriendRequest;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
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
    public List<FriendRequest> findByUserSender(String sender) throws FriendRequestException {
        return friendRequestRepository.findByUserSender(sender);
    }

    @Override
    public List<FriendRequest> findByUserReceiver(String receiver) throws FriendRequestException {
        return friendRequestRepository.findByUserReceiver(receiver);
    }

    @Override
    public List<FriendRequest> getListFriend(String username) throws FriendRequestException {
        return friendRequestRepository.getListFriendRequest(username);
    }

    @Override
    public int insertFriendRequest(FriendRequiredRequest request) throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        FriendRequest friendRequest = new FriendRequest(sender, receiver, (short) 0);
        return friendRequestRepository.insertFriendRequest(friendRequest);
    }

    @Override
    public int acceptFriendRequest(FriendRequiredRequest request) throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        return friendRequestRepository.acceptFriendRequest(sender, receiver);
    }

    @Override
    public int deleteFriendRequest(FriendRequiredRequest request) throws FriendRequestException {
        String sender = request.getSender();
        String receiver = request.getReceiver();
        return friendRequestRepository.deleteFriendRequest(sender, receiver);
    }
}
