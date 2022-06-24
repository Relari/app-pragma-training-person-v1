package com.co.pragma.training.service.app.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>Class:</b> PersonApplication.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.co.pragma.training.service.app.infrastructure")
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class);
	}

}
