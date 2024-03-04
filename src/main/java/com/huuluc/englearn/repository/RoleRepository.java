package com.huuluc.englearn.repository;

import com.huuluc.englearn.model.Role;
import com.huuluc.englearn.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleRepository {
    private final RoleMapper roleMapper;

    public List<Role> getAll() {
        return roleMapper.findAll();
    }
}
