package com.eugeniomoreira.nossobancodigital.domain.bean;

public class EmailBean {

    private final String emailAddress;
    private final String subject;
    private final String text;

    public EmailBean(String emailAddress, String subject, String text) {
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.text = text;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

}
