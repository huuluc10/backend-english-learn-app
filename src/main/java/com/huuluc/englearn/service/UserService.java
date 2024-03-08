package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.LevelException;
import com.huuluc.englearn.exception.MediaException;
import com.huuluc.englearn.exception.RoleException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.ChangePasswordRequest;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface UserService {
    ResponseEntity<ResponseModel> getByUsername(String username) throws UserException, LevelException, MediaException;

    ResponseEntity<ResponseModel> getByEmail(String email) throws UserException;

    UserDetails getByUsernameAndPassword(String username, String password) throws RoleException;

    ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException;

    ResponseEntity<ResponseModel> updateUser(UpdateInfoRequest request) throws UserException;

    ResponseEntity<ResponseModel> findAll() throws UserException;

    ResponseEntity<ResponseModel> updateAvatar(String username, MultipartFile avatar) throws UserException, MediaException;

    ResponseEntity<ResponseModel> changePassword(ChangePasswordRequest request) throws UserException, SQLIntegrityConstraintViolationException;
}
