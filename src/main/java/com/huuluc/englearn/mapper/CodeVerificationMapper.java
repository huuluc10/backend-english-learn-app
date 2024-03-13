package com.huuluc.englearn.mapper;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.model.CodeVerification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CodeVerificationMapper {

    @Insert("INSERT INTO code_verification (email, code, expired_at) VALUES (#{email}, #{code}, #{expiredAt})")
    int insertCodeVerification(CodeVerification codeVerification) throws CodeVerificationException;

    @Delete("DELETE FROM code_verification WHERE email = #{email}")
    int deleteCodeVerification(String email) throws CodeVerificationException;

    @Select("SELECT code FROM code_verification WHERE email = #{email} AND expired_at > NOW()")
    String getCodeVerification(String email) throws CodeVerificationException;
}
