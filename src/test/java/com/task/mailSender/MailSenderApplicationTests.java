package com.task.mailSender;

import com.task.mailSender.mail.MailToAllThread;
import com.task.mailSender.mail.Mailer;
import com.task.mailSender.mail.SmtpMailer;
import org.junit.Test;

import javax.mail.MessagingException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class MailSenderApplicationTests {

	@Test
	void contextLoads() {
		String[] addresses = {"tohidfla@gmail.com", "TohidHeshmatiDev@gmail.com", "wrong email"};
		String text = "text";
		String subject = "subject";
		String wrongUser = "wrong User";
		String wrongPassword = "wrong password";
		List<MailToAllThread> mailThreads = new ArrayList<>(1);
		try {
			Mailer mailer = new SmtpMailer();
			mailer.setTextAndSubject(text, subject);
			mailer.mailerConnct();
			MailToAllThread mailThread = new MailToAllThread(mailer, addresses);
			mailThreads.add(mailThread);
			mailThread.run();
			do {
				try {
					Thread.sleep(500);
				}catch (Exception e){
					assertTrue(e instanceof InterruptedException);
				}

				if (!mailThread.isAlive()) {
					mailThread.mailerRef.mailerDisconnect();
				}
			} while (mailThread.isAlive());

		} catch (Exception e) {
			assertTrue(e instanceof MessagingException);
		}
	}

}
