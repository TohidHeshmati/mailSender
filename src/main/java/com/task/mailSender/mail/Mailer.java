package com.task.mailSender.mail;

import javax.mail.MessagingException;

public interface Mailer {
    void send(String to, String subject, String body) throws MessagingException;
}
