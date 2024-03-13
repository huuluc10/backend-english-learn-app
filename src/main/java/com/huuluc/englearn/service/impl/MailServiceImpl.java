package com.huuluc.englearn.service.impl;

import com.huuluc.englearn.config.FreemarkerConfig;
import com.huuluc.englearn.model.MailStructure;
import com.huuluc.englearn.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import freemarker.template.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService  {
    private final JavaMailSender mailSender;
    private final Configuration config;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendMail(String to, MailStructure mailStructure) throws MessagingException, IOException, TemplateException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, String> model = Map.of("name", mailStructure.getName());

        Template t = config.getTemplate("welcome.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

//        message.setFrom(from);
//        message.setRecipients(Message.RecipientType.TO, to);
//        message.setSubject(mailStructure.getSubject(), "UTF-8");
//
//        Multipart mp = new MimeMultipart();
//        MimeBodyPart htmlPart = new MimeBodyPart();
//        htmlPart.setContent(mailStructure.getContent(), "text/html");
//        mp.addBodyPart(htmlPart);
//
//        message.setContent(mp);
//        mailSender.send(message);

        helper.setTo(to);
        helper.setText(html, true);
        helper.setSubject(mailStructure.getSubject());
        helper.setFrom(from);
        mailSender.send(message);
    }
}
