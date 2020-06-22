package com.task.mailSender.mail;

public class MailToAllThread extends Thread {
    public Mailer mailerRef;
    public String[] addresses;

    public MailToAllThread(Mailer mailer, String[] addresses){
        mailerRef=mailer;
        this.addresses = addresses;
    }

    @Override
    public void run(){
        for (String address : addresses){
            try {
                mailerRef.send(address, mailerRef.getMsgBody(), mailerRef.getSubject());
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}