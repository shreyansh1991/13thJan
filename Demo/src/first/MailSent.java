package first;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailSent {
public static void main(String[] args) throws EmailException {
	Email email = new SimpleEmail();
	email.setHostName("stbeehive.oracle.com"); // stbeehive.oracle.com
	email.setSmtpPort(993); // 993
	email.setAuthenticator(new DefaultAuthenticator("shreyansh.jain@oracle.com",			 "pinCode@261001"));
	
	email.setSSLOnConnect(true);
	email.setFrom("shreyansh.jain@oracle.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("venkatasravankumar.sagi@oracle.com");
	email.send();
	System.out.println("Sent...");
}
}
