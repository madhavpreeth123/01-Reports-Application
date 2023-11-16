package in.madhav.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sentEmails(String subject,String body,String to,File f) {
		try {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		helper.setSubject(subject);
		//is text contain any html tags - true/false
		helper.setText(body, true);
		helper.setTo("madhavpreeth394@gmail.com");
		helper.addAttachment("plans", f);
		mailSender.send(mimeMessage);
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
		
	}
}
