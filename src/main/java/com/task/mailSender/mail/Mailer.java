package com.task.mailSender.mail;

import javax.mail.MessagingException;

public interface Mailer {
    void send(String to, String subject, String body) throws MessagingException;

    void mailerConnct() throws MessagingException;
    void mailerDisconnect() throws MessagingException;

    String getMsgBody();
    String getSubject();

    void setTextAndSubject(String body, String subject);
}
