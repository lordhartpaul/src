import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;

// Created by Amit Gaur
// amitt800@gmail.com
// How to send email from Gmail in Java

public class GMail
{
	public static void main(String ss[])
	{
		String host = "smtp.gmail.com";
		String username = "amitt800";// Put here only Gmail username not full email id  
		String password = "amitamit";// Put here Gmail password
		int i;
		i=1;
		try
		{
			Properties props = new Properties();
			props.put("mail.smtps.auth", "true");
			//props.put("mail.from", "amitt800@gmail.com");
			props.put("mail.from",""); // put here from full gmail email id
			Session session = Session.getInstance(props, null);
			Transport t = session.getTransport("smtps");
			t.connect(host, username, password);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom();
			//msg.setRecipients(Message.RecipientType.TO, "amitt800@gmail.com");
			msg.setRecipients(Message.RecipientType.TO, ""); // put here receiver email id
			msg.setSubject("hello amit"+i);
			msg.setSentDate(new Date());
			msg.setText("Hello, Hi!"+i);
			t.sendMessage(msg, msg.getAllRecipients());
			
		}
		catch(Exception ee)
		{
			System.out.println(ee.toString());
		}
	}
}