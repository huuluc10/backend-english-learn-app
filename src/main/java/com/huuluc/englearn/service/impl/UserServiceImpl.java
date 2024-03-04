package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.CreateUserRequest;
import com.huuluc.englearn.repository.UserRepository;
import com.huuluc.englearn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
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
    public int createUser(CreateUserRequest request) {
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

        return userRepository.insertUser(user);
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
