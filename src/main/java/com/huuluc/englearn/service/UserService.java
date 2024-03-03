package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.User;
import com.huuluc.englearn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    public int insertUser(User user) {
        return userRepository.insertUser(user);
    }

    public int updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public int deleteUser(String username) {
        return userRepository.deleteUser(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
