package com.huuluc.englearn.service;

import com.huuluc.englearn.entity.Role;
import com.huuluc.englearn.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.getAll();
    }
}
