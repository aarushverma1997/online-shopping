package org.rv.shoppingbackend.dao;

public interface MailDAO {
	
	boolean sendMail(String to,String subject,String msg);

}
