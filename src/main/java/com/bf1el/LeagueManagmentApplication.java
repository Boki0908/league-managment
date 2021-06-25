package com.bf1el;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bf1el.common.CustomRepositoryImpl;

@SpringBootApplication
//ukljucujemo JPA Repo na niovu aplikacije, dakle u svakom Repositorijumu ce se implementirati
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class LeagueManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueManagmentApplication.class, args);
	}

}
