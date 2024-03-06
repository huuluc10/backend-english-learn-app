package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(String email);

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(String username, String password);

    @Insert("INSERT INTO user (username, full_name, date_of_birth, email, password, role_id, avatar, streak, experience) VALUES (#{username}, #{fullName}, #{dateOfBirth}, #{email}, #{password}, #{roleId}, #{avatar}, #{streak}, #{experience})")
    int insertUser(User user) throws UserException;

    @Select("UPDATE user SET fullName = #{fullName}, dateOfBirth = #{dateOfBirth}, email = #{email}, password = #{password}, roleId = #{roleId}, avatar = #{avatar}, streak = #{streak}, experience = #{experience} WHERE username = #{username}")
    int updateUser(User user);

    @Select("DELETE FROM user WHERE username = #{username}")
    int deleteUser(String username);

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password} AND roleId = #{roleId}")
    User findByUsernameAndPasswordAndRoleId(String username, String password, String roleId);
}
