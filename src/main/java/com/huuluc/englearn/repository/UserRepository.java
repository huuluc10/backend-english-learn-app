package com.huuluc.englearn.repository;

import com.huuluc.englearn.entity.User;
import com.huuluc.englearn.mapper.UserMapper;
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

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
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
