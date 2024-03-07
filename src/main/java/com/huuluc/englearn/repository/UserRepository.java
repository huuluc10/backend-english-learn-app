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

    public User getByEmail(String email) {
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

    public int deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User getByUsernameAndPasswordAndRoleId(String username, String password, String roleId) {
        return userMapper.findByUsernameAndPasswordAndRoleId(username, password, roleId);
    }

}
