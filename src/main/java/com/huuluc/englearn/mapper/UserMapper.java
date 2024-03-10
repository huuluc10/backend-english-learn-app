package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.User;
import com.huuluc.englearn.model.request.ChangePasswordRequest;
import com.huuluc.englearn.model.request.UpdateInfoRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findByEmail(String email) throws UserException;

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(String username, String password);

    @Insert("INSERT INTO user (username, full_name, date_of_birth, email, password, role_id, avatar, streak, experience) VALUES (#{username}, #{fullName}, #{dateOfBirth}, #{email}, #{password}, #{roleId}, #{avatar}, #{streak}, #{experience})")
    int insertUser(User user) throws UserException;

    @Select("UPDATE user SET full_name = #{fullName}, date_of_birth = #{dateOfBirth}, gender = #{gender}, email = #{email} WHERE username = #{username}")
    int updateInfoUser(UpdateInfoRequest request) throws UserException;

    @Select("SELECT * FROM user")
    List<User> findAll() throws UserException;

    @Update("UPDATE user SET avatar = #{mediaId} WHERE username = #{username}")
    int updateAvatar(String username, int mediaId) throws UserException;

    @Update("UPDATE user SET password = #{newPassword} WHERE username = #{username}")
    int changePassword(ChangePasswordRequest request) throws UserException, SQLIntegrityConstraintViolationException;

    @Update("UPDATE user SET streak = #{streak} WHERE username = #{username}")
    int updateStreak(String username, int streak) throws UserException;

}
