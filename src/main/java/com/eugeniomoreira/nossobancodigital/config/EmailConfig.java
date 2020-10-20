package com.eugeniomoreira.nossobancodigital.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    public Session getSession(@Value("${zup.email.transport.protocol}") String protocol,
                              @Value("${zup.email.user}") String email,
                              @Value("${zup.email.password}") String senha,
                              @Value("${zup.email.smtp.host}") String host,
                              @Value("${zup.email.smtp.port}") String port,
                              @Value("${zup.email.smtp.auth}") String auth,
                              @Value("${zup.email.smtp.starttls.enable}") String enable,
                              @Value("${zup.email.smtp.socketFactory.fallback}") String socketFactoryFallback,
                              @Value("${zup.email.smtp.socketFactory.port}") String socketFactoryPort) {
        Properties props = new Properties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", socketFactoryPort);
        props.put("mail.smtp.socketFactory.fallback", socketFactoryFallback);
        props.put("mail.smtp.starttls.enable", enable);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.port", port);

        return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, senha);
            }
        });
    }

}
