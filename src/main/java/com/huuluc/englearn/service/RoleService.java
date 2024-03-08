package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.RoleException;
import com.huuluc.englearn.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll() throws RoleException;
}
