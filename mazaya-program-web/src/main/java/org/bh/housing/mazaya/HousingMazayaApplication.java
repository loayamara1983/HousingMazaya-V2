package org.bh.housing.mazaya;

import org.bh.housing.mazaya.repo.generic.HMBaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = HMBaseRepositoryImpl.class)
public class HousingMazayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousingMazayaApplication.class, args);
	}
}
