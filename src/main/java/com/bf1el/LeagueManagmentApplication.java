package com.bf1el;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.bf1el.common.CustomRepositoryImpl;

@SpringBootApplication
//ukljucujemo JPA Repo na niovu aplikacije, dakle u svakom Repositorijumu ce se implementirati
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class LeagueManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueManagmentApplication.class, args);
	}
//	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	    
//	    mailSender.setUsername("my.gmail@gmail.com");
//	    mailSender.setPassword("password");
//	    
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	    
//	    return mailSender;
//	}

}
