package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.JwtTokenBlacklistException;
import com.huuluc.englearn.mapper.JwtTokenBlacklistMapper;
import com.huuluc.englearn.model.JwtTokenBlacklist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JwtTokenBlacklistRepository {
    private final JwtTokenBlacklistMapper mapper;

    public int revokeToken(JwtTokenBlacklist token) throws JwtTokenBlacklistException {
        return mapper.revokeToken(token);
    }

    public boolean exists(String token) throws JwtTokenBlacklistException {
        return mapper.findByToken(token) != null;
    }
}
