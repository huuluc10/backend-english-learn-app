package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.FriendRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendRequestMapper {
    @Select("SELECT sender, receiver, status FROM friend_request WHERE sender = #{sender}")
    List<FriendRequest> findBySender(String sender) throws FriendRequestException;

    @Select("SELECT sender, receiver, status FROM friend_request WHERE receiver = #{receiver}")
    List<FriendRequest> findByReceiver(String receiver) throws FriendRequestException;

    @Select("SELECT sender, receiver, status FROM friend_request WHERE receiver = #{username} OR sender = #{username} AND status = 1")
    List<FriendRequest> getListFriend(String username) throws FriendRequestException;

    @Insert("INSERT INTO friend_request (sender, receiver, status) VALUES (#{sender}, #{receiver}, #{status})")
    int insertFriendRequest(FriendRequest friendRequest) throws FriendRequestException;

    @Update("UPDATE friend_request SET status = 1 WHERE sender = #{sender} AND receiver = #{receiver}")
    int acceptFriendRequest(String sender, String receiver) throws FriendRequestException;

    @Delete("DELETE FROM friend_request WHERE (sender = #{sender} AND receiver = #{receiver}) OR (sender = #{receiver} AND receiver = #{sender})")
    int deleteFriendRequest(String sender, String receiver) throws FriendRequestException;
}
