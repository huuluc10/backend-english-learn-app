package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.repository.RoleRepository;
import com.huuluc.englearn.repository.UserRepository;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails getByUsername(String username) {
        User user = userRepository.getByUsername(username);
        Role role = roleRepository.getByRoleId(user.getRoleId());
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(role.getName())
                .build();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Override
    public ResponseEntity<ResponseModel> createUser(CreateUserRequest request) throws UserException {
        // Create a new user object
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setEmail(null);
        user.setRoleId((short) 1);
        user.setStreak(0);
        user.setAvatar(1);
        user.setExperience(0);

        ResponseModel responseModel;

        // Check if the response is successful
        if (userRepository.insertUser(user) == 1) {
           responseModel = new ResponseModel("success", "User created successfully", null);
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        } else {
            responseModel = new ResponseModel("error", "User creation failed", null);
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public int deleteUser(String username) {
        return userRepository.deleteUser(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
