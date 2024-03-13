package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.model.MailStructure;
import com.huuluc.englearn.model.request.AddEmailRequest;
import com.huuluc.englearn.model.request.VerifyCodeRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.MailService;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/otp")
@Tag(name = "Code OTP", description = "Code OTP API")
@Slf4j
public class CodeOTPController {
    private final MailService service;

    @PostMapping("/addEmail")
    @Operation(summary = "Sent code to email when user add email")
    public ResponseEntity<ResponseModel> sendMail(@RequestBody AddEmailRequest request) throws MessagingException, TemplateException, IOException {
        MailStructure mailStructure = new MailStructure(request.getEmail(),"Chào mừng bạn đã đến với EngLearn App");

        return service.addEmail(mailStructure, request.getUsername());
    }

    @PostMapping("/verifyCodeOTP")
    @Operation(summary = "Verify code OTP")
    public ResponseEntity<ResponseModel> verifyCodeOTP(@RequestBody VerifyCodeRequest request) throws CodeVerificationException {
        log.info("Verify code OTP");
        return service.verifyCode(request);
    }

    @PostMapping("/forgot-password/{email}")
    public String forgotPassword(@PathVariable String email) throws MessagingException, TemplateException, IOException, CodeVerificationException {
        MailStructure mailStructure = new MailStructure(email,"Khôi phục mật khẩu");
        service.forgotPassword(mailStructure);
        log.info("Mail sent to reset password");
        return "Mail sent";
    }

}
