package com.bf1el.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service("mailService")
public class MailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail(String fromAddress, String toAddress, String subject, String content) throws MessagingException {
		MimeMessage mimeMessage= javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom(fromAddress);
		mimeMessageHelper.setTo(toAddress);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content,true);
		mimeMessageHelper.setSentDate(new Date());
		javaMailSender.send(mimeMessage);

	}
}
