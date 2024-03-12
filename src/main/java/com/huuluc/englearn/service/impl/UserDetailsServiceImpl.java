package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.RoleException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.repository.RoleRepository;
import com.huuluc.englearn.repository.UserRepository;
import com.huuluc.englearn.utils.MessageStringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User userGetByUsername = userRepository.getByUsername(username);
            User userGetByEmail = userRepository.getByEmail(username);

            if (userGetByEmail == null && userGetByUsername == null) {
                throw new UsernameNotFoundException(MessageStringResponse.GET_USER_NOT_FOUND);
            }

            Role roleByUsername;

            if (userGetByUsername != null) {
                roleByUsername = roleRepository.getByRoleId(userGetByUsername.getRoleId());

                return org.springframework.security.core.userdetails.User.builder()
                        .username(userGetByUsername.getUsername())
                        .password(userGetByUsername.getPassword())
                        .roles(roleByUsername.getName())
                        .build();
            } else {
                roleByUsername = roleRepository.getByRoleId(userGetByEmail.getRoleId());
                return org.springframework.security.core.userdetails.User.builder()
                        .username(userGetByEmail.getUsername())
                        .password(userGetByEmail.getPassword())
                        .roles(roleByUsername.getName())
                        .build();
            }
        } catch (UserException | RoleException e) {
            throw new UsernameNotFoundException(e.toString());
        }
    }
}
