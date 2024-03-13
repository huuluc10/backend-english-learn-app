package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.request.FriendRequest;
import com.huuluc.englearn.mapper.FriendRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FriendRequestRepository {
    private final FriendRequestMapper friendRequestMapper;

    public List<FriendRequest> findByUserSender(String sender) throws FriendRequestException {
        return friendRequestMapper.findBySender(sender);
    }

    public List<FriendRequest> findByUserReceiver(String receiver) throws FriendRequestException {
        return friendRequestMapper.findByReceiver(receiver);
    }

    public List<FriendRequest> getListFriendRequest(String username) throws FriendRequestException {
        return friendRequestMapper.getListFriend(username);
    }

    public int insertFriendRequest(FriendRequest friendRequest) throws FriendRequestException {
        return friendRequestMapper.insertFriendRequest(friendRequest);
    }

    public int acceptFriendRequest(String sender, String receiver) throws FriendRequestException {
        return friendRequestMapper.acceptFriendRequest(sender, receiver);
    }

    public int deleteFriendRequest(String sender, String receiver) throws FriendRequestException {
        return friendRequestMapper.deleteFriendRequest(sender, receiver);
    }
}
