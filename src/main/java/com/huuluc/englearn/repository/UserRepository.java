package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.mapper.UserMapper;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserMapper userMapper;

    public User getByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User getByEmail(String email) throws UserException {
        return userMapper.findByEmail(email);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    public int insertUser(User user) throws UserException {
        return userMapper.insertUser(user);
    }

    public int updateUser(UpdateInfoRequest request) throws UserException {
        return userMapper.updateInfoUser(request);
    }

    public List<User> findAll() throws UserException {
        return userMapper.findAll();
    }

    public int updateAvatar(String username, int mediaId) throws UserException {
        return userMapper.updateAvatar(username, mediaId);
    }

}
