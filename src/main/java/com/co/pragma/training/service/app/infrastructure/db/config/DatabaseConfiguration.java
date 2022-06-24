package com.co.pragma.training.service.app.infrastructure.db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Lazy
@Configuration
@EnableJpaRepositories(basePackages = {"com.co.pragma.training.service.app.infrastructure.db.repository"})
@EntityScan(basePackages = "com.co.pragma.training.service.app.infrastructure.db.model")
public class DatabaseConfiguration {
}
