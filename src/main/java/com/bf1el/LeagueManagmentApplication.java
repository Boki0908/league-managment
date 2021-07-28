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

@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class LeagueManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueManagmentApplication.class, args);
	}


}
