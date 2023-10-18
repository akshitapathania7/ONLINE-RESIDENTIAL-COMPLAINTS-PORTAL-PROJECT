/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Mail
{

	//SETUP MAIL SERVER PROPERTIES
	//DRAFT AN EMAIL
	//SEND EMAIL
		
	Session newSession = null;
	MimeMessage mimeMessage = null;
        public void preparetoSendEmail(String emailSubject, String emailBody, String receipent) throws MessagingException, AddressException, IOException{
                setupServerProperties();
		draftEmail(emailSubject,emailBody,receipent);
		sendEmail();
        }
//	public static void main(String args[]) throws AddressException, MessagingException, IOException
//	{
//		Mail mail = new Mail();
//		mail.setupServerProperties();
//		mail.draftEmail(emailSubject,emailBody,receipent);
//		mail.sendEmail();
//	}

        private void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties,null);
	}
        
	private void sendEmail() throws MessagingException {
		String fromUser = "jukinaed2022@gmail.com";  //Enter sender email id
		String fromUserPassword = "JKaed@2022";  //Enter sender gmail password , this will be authenticated by gmail smtp server
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
		System.out.println("Email successfully sent!!!");
	}
        
        public static boolean validatePassword(String pwd) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN
                = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pwd);
        return matcher.matches();
    }


	private MimeMessage draftEmail(String emailSubject, String emailBody, String receipent) throws AddressException, MessagingException, IOException {
            ArrayList<String> emailReceipients = new ArrayList<>();
            emailReceipients.add("jukinaed2022@gmail.com");
            emailReceipients.add(receipent);
		mimeMessage = new MimeMessage(newSession);
		
		for (String rec:emailReceipients)
		{
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(rec));
		}
		mimeMessage.setSubject(emailSubject);
                mimeMessage.setContent(emailBody, "text/html");
	   
      // CREATE MIMEMESSAGE 
	    // CREATE MESSAGE BODY PARTS 
	    // CREATE MESSAGE MULTIPART 
	    // ADD MESSAGE BODY PARTS ----> MULTIPART 
	    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
	    
	    
//		 MimeBodyPart bodyPart = new MimeBodyPart();
//		 bodyPart.setContent(emailBody,"html/text");
//		 MimeMultipart multiPart = new MimeMultipart();
//		 multiPart.addBodyPart(bodyPart);
//		 mimeMessage.setContent(multiPart);
		 return mimeMessage;
	}	
}




