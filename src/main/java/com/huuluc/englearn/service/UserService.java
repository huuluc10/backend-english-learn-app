package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.User;

import java.util.List;

public interface UserService {
    User getByUsername(String username);

    User getByEmail(String email);

    User getByUsernameAndPassword(String username, String password);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(String username);

    List<User> findAll();
}
