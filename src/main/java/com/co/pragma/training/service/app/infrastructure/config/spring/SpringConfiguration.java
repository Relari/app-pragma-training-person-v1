package com.co.pragma.training.service.app.infrastructure.config.spring;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonCreateService;
import com.co.pragma.training.service.app.application.usecase.PersonSearchOlderAgesService;
import com.co.pragma.training.service.app.application.usecase.PersonSearchService;
import com.co.pragma.training.service.app.application.usecase.impl.PersonCreateServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.PersonSearchOlderAgesServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.PersonSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class SpringConfiguration {

    @Bean
    public PersonCreateService personCreateService(
            PersonDao personDao, ImageDao imageDao) {
        return new PersonCreateServiceImpl(personDao, imageDao);
    }

    @Bean
    public PersonSearchOlderAgesService personSearchOlderAgesService(
            PersonDao personDao, ImageDao imageDao) {
        return new PersonSearchOlderAgesServiceImpl(personDao, imageDao);
    }

    @Bean
    public PersonSearchService personSearchService(
            PersonDao personDao, ImageDao imageDao) {
        return new PersonSearchServiceImpl(personDao, imageDao);
    }

}
