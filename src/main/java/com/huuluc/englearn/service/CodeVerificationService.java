package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.model.CodeVerification;

public interface CodeVerificationService {
    int insertCodeVerification(CodeVerification codeVerification) throws CodeVerificationException;
    int deleteCodeVerification(String email) throws CodeVerificationException;

    String getCodeVerification(String email) throws CodeVerificationException;
}
