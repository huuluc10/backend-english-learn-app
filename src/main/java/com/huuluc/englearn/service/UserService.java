package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    ResponseEntity<ResponseModel> getByUsername(String username) throws UserException;

    ResponseEntity<ResponseModel> getByEmail(String email) throws UserException;

    UserDetails getByUsernameAndPassword(String username, String password);

    ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException;

    ResponseEntity<ResponseModel> updateUser(UpdateInfoRequest request) throws UserException;

    ResponseEntity<ResponseModel> findAll() throws UserException;

    ResponseEntity<ResponseModel> updateAvatar(String username, MultipartFile avatar) throws UserException, MediaException;
}
