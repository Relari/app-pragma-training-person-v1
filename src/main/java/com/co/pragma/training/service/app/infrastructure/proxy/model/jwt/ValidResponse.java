package com.co.pragma.training.service.app.infrastructure.proxy.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidResponse {

    private Boolean isValidToken;

}
