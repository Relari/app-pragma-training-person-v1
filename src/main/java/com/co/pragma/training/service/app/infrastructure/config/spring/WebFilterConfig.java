package com.co.pragma.training.service.app.infrastructure.config.spring;

import com.co.pragma.training.service.app.infrastructure.proxy.api.JwtTokenApi;
import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.ValidResponse;
import java.io.IOException;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;



@Lazy
@Configuration
@AllArgsConstructor
public class WebFilterConfig implements WebFilter {

    private final HeaderApplication headerApplication;
    private final JwtTokenApi jwtTokenApi;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String authorization = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(authorization)) {

            var status = HttpStatus.UNAUTHORIZED;
            throw new ResponseStatusException(status, status.getReasonPhrase());

        } else {

            headerApplication.setBearerToken(authorization);

            ValidResponse validResponse;
            try {
                validResponse = jwtTokenApi.validateToken(authorization)
                        .execute()
                        .body();
            } catch (IOException e) {
                var status = HttpStatus.FORBIDDEN;
                throw new ResponseStatusException(status, status.getReasonPhrase());
            }

            assert validResponse != null;
            if (!Boolean.TRUE.equals(validResponse.getIsValidToken())) {
                var status = HttpStatus.FORBIDDEN;
                throw new ResponseStatusException(status, status.getReasonPhrase());
            }

        }

        return chain.filter(exchange);
    }

}
