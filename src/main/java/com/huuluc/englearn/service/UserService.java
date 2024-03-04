package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    UserDetails getByUsername(String username);

    User getByEmail(String email);

    UserDetails getByUsernameAndPassword(String username, String password);

    ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException;

    int updateUser(User user);

    int deleteUser(String username);

    List<User> findAll();
}
