package org.rv.shoppingbackend.daoImpl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.rv.shoppingbackend.dao.MailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("mailDAO")
@Transactional
public class MailDAOImpl implements MailDAO {
	
	
	private JavaMailSender mailSender;
	
	

	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	



	public JavaMailSender getMailSender() {
		return mailSender;
	}





	@Override
	public boolean sendMail(String to, String subject,String msg) {
		boolean b= false;
		
		try {
			
			MimeMessagePreparator prep = new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
					mimeMessage.setSubject(subject);
					mimeMessage.setContent(msg, "text/html;charset=utf-8");
				
					
				}
				
			};
			
			mailSender.send(prep);
			
			return b= true;
			
		} catch (Exception e) {
			
			return b=false;
			
		}
		
		
		
		
		
	}

}
