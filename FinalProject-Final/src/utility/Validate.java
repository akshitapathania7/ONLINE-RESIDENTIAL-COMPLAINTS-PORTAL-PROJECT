/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import javax.mail.internet.AddressException;
import userinterface.Police.felony.FelonyWorkAreaJPanel;
import userinterface.SignUp.AuthenticationJPanel;

/**
 *
 * @author srivaishnaviaekkati
 */

public class Validate {

    //Validating Name with regular Expression.
    public static boolean validateName(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z]{1,}[\\s]{0,1}[A-Za-z]{0,}$" ;
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean validateUserName(String name) {
        Pattern pattern;
        Matcher matcher;
        String NAME_PATTERN = "^[A-Za-z]{1,}[\\._]{0,1}[A-Za-z]{0,}$";
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public static boolean validateEmail(String hex) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    /**
     * Password check ^ # start-of-string (?=.*[0-9]) # a digit must occur at
     * least once (?=.*[a-z]) # a lower case letter must occur at least once
     * (?=.*[A-Z]) # an upper case letter must occur at least once
     * (?=.*[@#$%^&+=]) # a special character must occur at least once (?=\S+$)
     * # no whitespace allowed in the entire string .{8,} # anything, at least
     * eight places though $ # end-of-string
     *
     * @param pwd
     * @return
     */
    public static boolean validatePassword(String pwd) {
        Pattern pattern;
        Matcher matcher;
        String PASSWORD_PATTERN
                = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=~|?])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pwd);
        return matcher.matches();
    }


    public static void sendMessage2(String emailId, String mes) throws SendFailedException, MessagingException {
        // Recipient's email ID needs to be mentioned.
        String to = emailId;

        String from = "srivaishnavi.a@gmail.com";
        String pass = "kziwmqhrdfgzjvou";

        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        // properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session); 

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Police");

            message.setText(mes);
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            //mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
       
     public static void sendMessage(String emailId, String mes) throws SendFailedException, MessagingException {
         try {
             ValidateMail valMail = new ValidateMail();
                try {
                 //Validate.sendMessage1(emailtxtfield.getText(),n);
                 valMail.preparetoSendEmail("This is Subject", "We will send the Team shortly : " , "vaishnavi.asv@gmail.com");
                } catch (AddressException ex) {
                    Logger.getLogger(AuthenticationJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Mail has been sent....");
              
        //    JOptionPane.showMessageDialog("Mail has been sent");
       
        } catch (MessagingException ex) {
            Logger.getLogger(FelonyWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
         //   JOptionPane.showMessageDialog(this,"Mail has not  been sent");
        }
     }
    
     public static void sendMessage1(String emailId, int mes) throws SendFailedException, MessagingException {
        // Recipient's email ID needs to be mentioned.
        String to = emailId;

        String from = "srivaishnavi.a@gmail.com";
        String pass = "kziwmqhrdfgzjvou";

        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", from);
        // properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
        //    MimeMessage message = new MimeMessage(session);
        
        MimeMessage message = null;

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Authentication");
           
            message.setText(Integer.toString(mes));
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            //mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }
  

  

}
