package pe.edu.upc.quyawar.common;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface ISenderMail {
	
	public void send(String to, String subject, String message) throws AddressException, MessagingException;
	
}
