/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import frame.*;

/**
 *
 * @author Rems
 */
public class GangAuthority {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	try {
    		String mailSmtpHost = "smtp.free.fr";

    		String mailTo = "kevin.suy@me.com";
    		//String mailCc = "littlecakes@cakelycakes.com";
    		String mailFrom = "caca@gmail.com";
    		String mailSubject = "Email from Java";
    		String mailText = "This is an email from Java";
    		
			Properties properties = new Properties();
			properties.put("mail.smtp.host", mailSmtpHost);
			Session emailSession = Session.getDefaultInstance(properties);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			//emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(mailCc));
			emailMessage.setFrom(new InternetAddress(mailFrom));
			emailMessage.setSubject(mailSubject);
			emailMessage.setText(mailText);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        //Accueil page = new Accueil();
        //page.main(args);
    }
    
}
