package com.task.mailSender.mail;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockMailer implements Mailer {

    private static Log log = LogFactory.getLog(MockMailer.class);


    @Override
    public void send(String to, String subject, String body) {
        log.info("sending mock mail to: "+to);
        log.info("subject set to: "+subject);
        log.info("body set to: "+body);
    }
}
