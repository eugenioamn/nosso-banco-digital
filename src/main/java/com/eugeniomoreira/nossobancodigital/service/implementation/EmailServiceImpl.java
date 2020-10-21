package com.eugeniomoreira.nossobancodigital.service.implementation;

import com.eugeniomoreira.nossobancodigital.domain.bean.EmailBean;
import com.eugeniomoreira.nossobancodigital.domain.exception.InternalServiceErrorException;
import com.eugeniomoreira.nossobancodigital.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${zup.email.user}")
    private String emailUser;

    private final Session session;

    public EmailServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public void send(EmailBean emailBean) {
        try {
            session.setDebug(true);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailUser));
            Address[] toUser = InternetAddress
                    .parse(emailBean.getEmailAddress());
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(emailBean.getSubject());
            message.setText(emailBean.getText());
            Transport.send(message);
        } catch (MessagingException ex) {
            throw new InternalServiceErrorException(ex);
        }
    }

}
