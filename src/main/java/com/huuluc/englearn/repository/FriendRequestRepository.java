package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.FriendRequest;
import com.huuluc.englearn.mapper.FriendRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FriendRequestRepository {
    private final FriendRequestMapper friendRequestMapper;

    public List<FriendRequest> findByUserSender(String sender) {
        return friendRequestMapper.findBySender(sender);
    }

    public int insertFriendRequest(FriendRequest friendRequest) {
        return friendRequestMapper.insertFriendRequest(friendRequest);
    }

    public int acceptFriendRequest(String sender, String receiver) {
        return friendRequestMapper.acceptFriendRequest(sender, receiver);
    }

    public int deleteFriendRequest(String sender, String receiver) {
        return friendRequestMapper.deleteFriendRequest(sender, receiver);
    }
}
