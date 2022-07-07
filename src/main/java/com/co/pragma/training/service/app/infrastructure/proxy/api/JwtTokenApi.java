package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.jwt.ValidResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface JwtTokenApi {

    @POST("token/validate")
    Call<ValidResponse> validateToken(
            @Header("Authorization") String queryParams
    );

}
