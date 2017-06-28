package pe.edu.upc.quyawar.common.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import pe.gob.sernanp.ves.common.ISenderMail;

public class SenderMailImpl implements ISenderMail {
	
	private Session session;
	private String host;
	private String username;
	
	public SenderMailImpl (String host, String port, final String username, final String password) {
		
		Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable","false");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", port);
        
        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication 
            getPasswordAuthentication() {
            	return new PasswordAuthentication(username, password);
            }
    	});
	}
	
	@Override
	public void send(String to, String subject, String message) throws AddressException, MessagingException {
		
		Message msg = new MimeMessage(session);
		
        msg.setFrom(new InternetAddress("Sernanp<" + this.getUsername() + ">"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject(subject);
        msg.setContent(message, "text/html");
        System.out.println("enviando mensaje a " + to);
        Transport.send(msg);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
