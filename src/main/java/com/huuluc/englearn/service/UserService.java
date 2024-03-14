package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.request.*;
import com.huuluc.englearn.model.response.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLIntegrityConstraintViolationException;

public interface UserService {
    ResponseEntity<ResponseModel> getByUsername(String username) throws UserException, LevelException, MediaException, UserMissionException;

    ResponseEntity<ResponseModel> createUser(SignupRequest request) throws UserException;

    ResponseEntity<ResponseModel> updateUser(UpdateInfoRequest request) throws UserException;

    ResponseEntity<ResponseModel> findAll() throws UserException;

    ResponseEntity<ResponseModel> updateAvatar(String username, MultipartFile avatar) throws UserException, MediaException;

    ResponseEntity<ResponseModel> changePassword(ChangePasswordRequest request) throws UserException, SQLIntegrityConstraintViolationException;

    int increaseStreak(String username) throws UserException, UserMissionException;

    boolean existsByUsername(String username) throws UserException;

    boolean existsByEmail(String email) throws UserException;

    ResponseEntity<ResponseModel> addEmail(AddEmailRequest request) throws UserException;

    ResponseEntity<ResponseModel> resetPassword(ResetPasswordRequest request) throws UserException;
}
