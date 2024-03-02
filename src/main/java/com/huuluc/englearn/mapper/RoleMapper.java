package com.huuluc.englearn.mapper;

import com.huuluc.englearn.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("SELECT role_id, name FROM role")
    List<Role> findAll();
}
