package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.FriendRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendRequestMapper {
    @Select("SELECT sender, receiver, status FROM friend_request WHERE sender = #{sender}")
    List<FriendRequest> findBySender(String sender);

    @Insert("INSERT INTO friend_request (sender, receiver, status) VALUES (#{sender}, #{receiver}, #{status})")
    int insertFriendRequest(FriendRequest friendRequest);

    @Update("UPDATE friend_request SET status = 1 WHERE sender = #{sender} AND receiver = #{receiver}")
    int acceptFriendRequest(String sender, String receiver);

    @Delete("DELETE FROM friend_request WHERE sender = #{sender} AND receiver = #{receiver}")
    int deleteFriendRequest(String sender, String receiver);
}
