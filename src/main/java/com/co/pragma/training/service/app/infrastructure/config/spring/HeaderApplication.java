package com.co.pragma.training.service.app.infrastructure.config.spring;

import lombok.Setter;
import org.springframework.http.HttpHeaders;


public class HeaderApplication {

    @Setter
    private HttpHeaders headers;

    public String getAuthorization() {
        return headers.getFirst("Authorization");
    }
}
