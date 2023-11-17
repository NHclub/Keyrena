package com.nhclub.keyrena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KeyrenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyrenaApplication.class, args);
	}

}
