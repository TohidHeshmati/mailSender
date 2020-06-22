package com.task.mailSender;

import com.task.mailSender.mail.MailToAllThread;
import com.task.mailSender.mail.Mailer;
import com.task.mailSender.mail.SmtpMailer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MailSenderApplication {

	public static void main(String args[]) throws MessagingException, InterruptedException {
		// Question explanation was not complete so I assumed list of mails as following
		String[] addresses = {"tohidfla@gmail.com", "TohidHeshmatiDev@gmail.com", "test1@gmail.com",
				"test2@gmail.com", "test3@gmail.com", "test4@gmail.com" ,"tohidfla@gmail.com", "TohidHeshmatiDev@gmail.com", "test1@gmail.com",
				"test2@gmail.com", "test3@gmail.com", "test4@gmail.com" ,"tohidfla@gmail.com", "TohidHeshmatiDev@gmail.com", "test1@gmail.com",
				"test2@gmail.com", "test3@gmail.com", "test4@gmail.com" ,"tohidfla@gmail.com", "TohidHeshmatiDev@gmail.com", "test1@gmail.com",
				"test2@gmail.com", "test3@gmail.com", "test4@gmail.com"};
		int numberOfThreads = Systemconfig.getNumberOfThreads();

		String msgText = Systemconfig.getDefaultMsgText();
		String msgSubject = Systemconfig.getDefaultMsgSubject();
		int length = addresses.length;

		List<MailToAllThread> mailThreads = new ArrayList<>(numberOfThreads);

		for (int i=0; i<numberOfThreads; i++){
			String[] list = Arrays.copyOfRange(addresses,
					(i)*(length/numberOfThreads), (i+1)*length/numberOfThreads);
			Mailer mailer = new SmtpMailer();
			mailer.setTextAndSubject(msgText, msgSubject);
			mailer.mailerConnct();
			MailToAllThread mailThread = new MailToAllThread(mailer, list);
			mailThreads.add(mailThread);
			mailThread.run();
		}


		// check every 5 seconds to disconnect finished mailers
		int numberOfMailers = numberOfThreads;
		do {
			for (MailToAllThread mailThread : mailThreads){
				if (!mailThread.isAlive()){
					mailThread.mailerRef.mailerDisconnect();
					numberOfMailers -=1;
				}
			}
			Thread.sleep(5000);
		}while (numberOfMailers>0);
	}
}