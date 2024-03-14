package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.exception.CodeVerificationException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.CodeVerification;
import com.huuluc.englearn.model.MailStructure;
import com.huuluc.englearn.model.request.VerifyCodeRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.CodeVerificationService;
import com.huuluc.englearn.service.MailService;
import com.huuluc.englearn.service.UserService;
import com.huuluc.englearn.utils.MessageStringResponse;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService  {

    private final JavaMailSender mailSender;
    private final CodeVerificationService codeVerificationService;
    private final UserService userService;
    private final Configuration config;
    private final Random random = new Random();

    @Value("${spring.mail.username}")
    private String from;

    // Random 6 unsigned digits code
    private String generateCode() {
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private String getBodyMail(String namefile, Map<String, String> model) throws IOException, TemplateException {
        Template t = config.getTemplate(namefile);
        return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
    }

    private int insertCodeVerification(MailStructure mailStructure, String code) throws CodeVerificationException {
        // Create CodeVerification object
        CodeVerification codeVerification = new CodeVerification();
        codeVerification.setEmail(mailStructure.getTo());
        codeVerification.setCode(code);
        codeVerification.setExpiredAt(new Date(System.currentTimeMillis() + 300000)); // 5 minutes

        // Insert into table code_verification
        return  codeVerificationService.insertCodeVerification(codeVerification);
    }

    @Override
    public ResponseEntity<ResponseModel> forgotPassword(MailStructure mailStructure) throws CodeVerificationException, UserException {
        ResponseModel responseModel;

        if (!userService.existsByEmail(mailStructure.getTo())) {
            responseModel = new ResponseModel(MessageStringResponse.ERROR, "Email not found", null);
            return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
        }

        try {
            String code = generateCode();


            int resultInsert = insertCodeVerification(mailStructure, code);

            if (resultInsert == 0) {
                responseModel = new ResponseModel(MessageStringResponse.ERROR,
                        MessageStringResponse.INIT_VERIFY_CODE_FAILED, null);
                return ResponseEntity.badRequest().body(responseModel);
            }

            // Send mail
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            //List of parameters in html file
            Map<String, String> model = Map.of("code", code);
            //Get html file
            String html = getBodyMail("reset_password.ftl", model);

            helper.setTo(mailStructure.getTo());
            helper.setText(html, true);
            helper.setSubject(mailStructure.getSubject());
            helper.setFrom(from);
            mailSender.send(message);

            responseModel = new ResponseModel(MessageStringResponse.SUCCESS, "Mail sent", null);
            return ResponseEntity.ok().body(responseModel);

        } catch (MessagingException | IOException | TemplateException e) {
            responseModel = new ResponseModel(MessageStringResponse.ERROR, e.getMessage(), null);
            return ResponseEntity.badRequest().body(responseModel);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> addEmail(MailStructure mailStructure, String name) throws UserException {
        ResponseModel responseModel;

        if (userService.existsByEmail(mailStructure.getTo())) {
            responseModel = new ResponseModel(MessageStringResponse.ERROR, "Email already exists", null);
            return ResponseEntity.badRequest().body(responseModel);
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            String code = generateCode();

            int resultInsert = insertCodeVerification(mailStructure, code);

            if (resultInsert == 0) {
                responseModel = new ResponseModel(MessageStringResponse.ERROR,
                        MessageStringResponse.INIT_VERIFY_CODE_FAILED, null);
                return ResponseEntity.badRequest().body(responseModel);
            }

            // List of parameters in html file
            Map<String, String> model = Map.of("code", code, "name", name);

            // Get html file
            String html = getBodyMail("welcome.ftl", model);

            helper.setTo(mailStructure.getTo());
            helper.setText(html, true);
            helper.setSubject(mailStructure.getSubject());
            helper.setFrom(from);
            mailSender.send(message);

            responseModel = new ResponseModel(MessageStringResponse.SUCCESS, "Mail sent", null);
            return ResponseEntity.ok().body(responseModel);
        } catch (MessagingException | IOException | TemplateException e) {
            responseModel = new ResponseModel(MessageStringResponse.ERROR,
                    MessageStringResponse.INIT_VERIFY_CODE_FAILED, null);
            return ResponseEntity.badRequest().body(responseModel);
        } catch (CodeVerificationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<ResponseModel> verifyCode(VerifyCodeRequest request) throws CodeVerificationException {
        // Get code from table code_verification
        String code = codeVerificationService.getCodeVerification(request.getEmail());

        if (code == null || code.isEmpty()) {
            return ResponseEntity.badRequest().body(new ResponseModel(MessageStringResponse.ERROR, "Code is expired", null));
        }

        if (Objects.equals(request.getCode(), code)) {
            codeVerificationService.deleteCodeVerification(request.getEmail());
            return ResponseEntity.ok().body(new ResponseModel(MessageStringResponse.SUCCESS, "Code is correct", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseModel(MessageStringResponse.ERROR, "Code is incorrect", null));
        }
    }
}
