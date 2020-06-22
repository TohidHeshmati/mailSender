package com.task.mailSender.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.geom.AffineTransform;
import java.util.Date;
import java.util.Properties;
import com.sun.mail.smtp.SMTPTransport;

@Component("smtp")
public class SmtpMailer implements Mailer{

    public Message msg;
    private String msgBody = "no message text set";
    private String subject = "no subject set";
    private SMTPTransport t;
    private Session session;

    @Value("${user.name}")
    private String fromUser;

    @Value("${user.password}")
    private String password;

    public SmtpMailer() throws MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        this.session = Session.getInstance(props, null);
        this.t = (SMTPTransport)session.getTransport("smtps");
        msgBuilder();
    }

    private void msgBuilder() throws MessagingException {
        this.msg = new MimeMessage(session);
        this.msg.setFrom(new InternetAddress(this.fromUser));
        this.msg.setSentDate(new Date());
        this.msg = new MimeMessage(session);
        this.msg.setSentDate(new Date());
    }

    @Override
    public void send(String to, String subject, String body) throws MessagingException {
        this.msg.setSubject(subject);
        this.msg.setText(body);
        this.msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to, false));
        t.sendMessage(msg, msg.getAllRecipients());
    }

    public void mailerConnct() throws MessagingException {

        this.t.connect("smtp.gmail.com", this.fromUser, this.password);
    }
    public void mailerDisconnect() throws MessagingException {this.t.close();}

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getSubject() {
        return subject;
    }
}
