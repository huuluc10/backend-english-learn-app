package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.request.ChangePasswordRequest;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    ResponseEntity<ResponseModel> getByUsername(String username) throws UserException, LevelException, MediaException, UserMissionException;

    ResponseEntity<ResponseModel> getByEmail(String email) throws UserException, UserMissionException;

    UserDetails getByUsernameAndPassword(String username, String password) throws RoleException;

    ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException;

    ResponseEntity<ResponseModel> updateUser(UpdateInfoRequest request) throws UserException;

    ResponseEntity<ResponseModel> findAll() throws UserException;

    ResponseEntity<ResponseModel> updateAvatar(String username, MultipartFile avatar) throws UserException, MediaException;

    ResponseEntity<ResponseModel> changePassword(ChangePasswordRequest request) throws UserException, SQLIntegrityConstraintViolationException;

    int increaseStreak(String username) throws UserException, UserMissionException;
}
