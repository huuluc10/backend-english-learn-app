package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.entity.Role;
import com.huuluc.englearn.repository.RoleRepository;
import com.huuluc.englearn.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.getAll();
    }
}
