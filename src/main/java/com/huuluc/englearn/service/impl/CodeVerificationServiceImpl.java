package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.model.CodeVerification;
import com.huuluc.englearn.repository.CodeVerificationRepository;
import com.huuluc.englearn.service.CodeVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeVerificationServiceImpl implements CodeVerificationService {
    private final CodeVerificationRepository repository;
    @Override
    public int insertCodeVerification(CodeVerification codeVerification) throws CodeVerificationException {
        return repository.insertCodeVerification(codeVerification);
    }

    @Override
    public int deleteCodeVerification(String email) throws CodeVerificationException {
        return repository.deleteCodeVerification(email);
    }

    @Override
    public String getCodeVerification(String email) throws CodeVerificationException {
        return repository.getCodeVerification(email);
    }
}
