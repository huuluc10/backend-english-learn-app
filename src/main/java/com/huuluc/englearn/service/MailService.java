package com.huuluc.englearn.service;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.model.MailStructure;
import com.huuluc.englearn.model.request.VerifyCodeRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface MailService {

    ResponseEntity<ResponseModel> addEmail(MailStructure mailStructure, String name) throws MessagingException, IOException, TemplateException;

    ResponseEntity<ResponseModel> forgotPassword(MailStructure mailStructure) throws MessagingException, IOException, TemplateException, CodeVerificationException;

    ResponseEntity<ResponseModel> verifyCode(VerifyCodeRequest request) throws CodeVerificationException;

}
