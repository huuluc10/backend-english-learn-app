package com.huuluc.englearn.repository;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.mapper.CodeVerificationMapper;
import com.huuluc.englearn.model.CodeVerification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CodeVerificationRepository {
    private final CodeVerificationMapper codeVerificationMapper;

    public int insertCodeVerification(CodeVerification codeVerification) throws CodeVerificationException {
        return codeVerificationMapper.insertCodeVerification(codeVerification);
    }

    public int deleteCodeVerification(String email) throws CodeVerificationException {
        return codeVerificationMapper.deleteCodeVerification(email);
    }

    public String getCodeVerification(String email) throws CodeVerificationException {
        return codeVerificationMapper.getCodeVerification(email);
    }
}
