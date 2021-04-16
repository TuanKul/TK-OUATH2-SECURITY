package net.kuleasycode.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(value = "net.kuleasycode")
@EnableJpaRepositories(value = "net.kuleasycode.repository")
@EntityScan(basePackages = "net.kuleasycode")
@EnableTransactionManagement
@EnableResourceServer
public class TkOuath2SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkOuath2SecurityApplication.class, args);
	}

}
