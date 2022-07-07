package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.image.ImageResponse;
import com.co.pragma.training.service.app.infrastructure.proxy.model.image.ImageRequest;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.*;

public interface ImageApi {

  @POST("images")
  Completable save(
          @Header("Authorization") String authorization,
          @Body ImageRequest imageRequest
  );

  @GET("images/{idPerson}")
  Single<ImageResponse> getImage(
          @Header("Authorization") String authorization,
          @Path("idPerson") Long id
  );

}
