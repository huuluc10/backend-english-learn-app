package com.huuluc.englearn.service;

import com.huuluc.englearn.model.MailStructure;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface MailService {

    void sendMail(String to, MailStructure mailStructure) throws MessagingException, IOException, TemplateException;
}
