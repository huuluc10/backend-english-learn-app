package com.huuluc.englearn.service;

import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;

import java.util.List;

public interface UserService {
    User getByUsername(String username);

    User getByEmail(String email);

    User getByUsernameAndPassword(String username, String password);

    int createUser(CreateUserRequest request);

    int updateUser(User user);

    int deleteUser(String username);

    List<User> findAll();
}
