package com.co.pragma.training.service.app.infrastructure.proxy.api;

import com.co.pragma.training.service.app.infrastructure.proxy.model.ImageResponse;
import com.co.pragma.training.service.app.infrastructure.proxy.model.ImageRequest;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ImageApi {

  @POST("images")
  Completable save(
          @Body ImageRequest imageRequest
  );

  @GET("images/{idPerson}")
  Single<ImageResponse> getImage(
          @Path("idPerson") Long id
  );

}
