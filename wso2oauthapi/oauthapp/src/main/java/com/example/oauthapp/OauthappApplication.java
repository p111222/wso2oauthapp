package com.example.oauthapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// @SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OauthappApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthappApplication.class, args);

	}

}
