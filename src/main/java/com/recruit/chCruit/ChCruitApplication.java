package com.recruit.chCruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChCruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChCruitApplication.class, args);
	}

}
