package first;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
public class HtmlReportWithAttachment {
public static void main(String[] args) throws EmailException, IOException {
	


	  // Create the email message
	  HtmlEmail email = new HtmlEmail();
	  email.setHostName("stbeehive.oracle.com");
	  email.setSmtpPort(993);
	  email.addTo("venkatasravankumar.sagi@oracle.com","Sravan");
	  
	  //email.addTo("jdoe@somewhere.org", "John Doe");
	  email.setFrom("shreyansh.jain@oracle.com", "Me");
	  email.setAuthenticator(new DefaultAuthenticator("shreyansh.jain@oracle.com",			 "pinCode@261001"));
		
		email.setSSLOnConnect(true);
		
	  email.setSubject("Test email with html report ");
	  
	  // embed the image and get the content id
	//  URL url = new URL("C:\\Users\\shreyanj\\eclipse-workspace\\JSP\\WebContent\\report.html");
	//  String cid = email.embed(url, "Apache logo");
	  
	  
	  // set the html message
	//  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

	  email.setHtmlMsg("<div style='font-size: 20px; color: green;'>This is html email</div>");
	  
	  EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("C:\\Users\\shreyanj\\eclipse-workspace\\JSP\\WebContent\\report.html");
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  //email.attach(attachment);
	  
	 
	  email.attach(new ByteArrayDataSource("", "application/html"),
		      "C:\\Users\\shreyanj\\eclipse-workspace\\JSP\\WebContent\\report.html", "Document description",
		       EmailAttachment.ATTACHMENT);

	  
	  // set the alternative message
	  email.setTextMsg("Your email client does not support HTML messages");

	  // send the email
	  email.send();
	  System.out.println("sent.");
}
}
