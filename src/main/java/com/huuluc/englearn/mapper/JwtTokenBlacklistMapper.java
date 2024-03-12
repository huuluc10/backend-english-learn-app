package com.huuluc.englearn.mapper;

import com.huuluc.englearn.model.JwtTokenBlacklist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface JwtTokenBlacklistMapper {
    @Insert("INSERT INTO jwt_token_blacklist (token, expire_at) VALUES (#{token}, #{expireAt})")
    int revokeToken(JwtTokenBlacklist jwt);

    @Select("SELECT token FROM jwt_token_blacklist WHERE token = #{token}")
    String findByToken(String token);
}
