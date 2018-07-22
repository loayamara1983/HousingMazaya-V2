package org.bh.housing.mazaya.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@SpringBootConfiguration
public class DatabaseConfig {

	@PostConstruct
	public void init() {
		System.out.println("config");
	}
}
