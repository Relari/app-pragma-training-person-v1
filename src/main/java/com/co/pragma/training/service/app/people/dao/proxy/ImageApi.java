package com.co.pragma.training.service.app.people.dao.proxy;

import com.co.pragma.training.service.app.people.model.external.ImageRequest;
import com.co.pragma.training.service.app.people.model.external.ImageResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;

public interface ImageApi {

  @POST("images")
  Completable save(
          @Body ImageRequest imageRequest
  );

  @GET("images")
  Observable<ImageResponse> getImages();

  @GET("images/{code}")
  Single<ImageResponse> getImage(
          @Path("code") Long id
  );

}
