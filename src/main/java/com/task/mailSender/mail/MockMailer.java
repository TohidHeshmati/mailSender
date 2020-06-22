package com.task.mailSender.mail;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.MessagingException;

public class MockMailer implements Mailer {

    private static Log log = LogFactory.getLog(MockMailer.class);

    private String msgBody = "this is a mock mail";
    private String subject = "no subject set for mock mail";


    @Override
    public void send(String to, String subject, String body) {
        log.info("sending mock mail to: "+to);
        log.info("subject set to: "+subject);
        log.info("body set to: "+body);
    }

    @Override
    public void mailerConnct() throws MessagingException {
        log.info("mailer connected ");
    }

    @Override
    public void mailerDisconnect() throws MessagingException {
        log.info("mailer disconnected ");
    }

    @Override
    public String getMsgBody() {
        return "this is a mock mail";
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setTextAndSubject(String body, String subject) {
        this.msgBody = body;
        this.subject = subject;
        log.info("body: "+body+" subject: "+subject);
    }
}
