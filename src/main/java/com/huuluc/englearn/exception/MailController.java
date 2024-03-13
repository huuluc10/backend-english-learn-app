package com.huuluc.englearn.exception;

import com.huuluc.englearn.model.MailStructure;
import com.huuluc.englearn.service.MailService;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
@Tag(name = "Mail", description = "Mail API")
@Slf4j
public class MailController {
    private final MailService mailService;




}
