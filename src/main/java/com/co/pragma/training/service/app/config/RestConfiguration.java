package com.co.pragma.training.service.app.config;

import com.co.pragma.training.service.app.people.dao.proxy.ImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Lazy
@Configuration
public class RestConfiguration {

  @Value("${application.http-client.image.base-url}")
  private String imageUri;

  private Retrofit retrofit(String uri) {
    return new Retrofit.Builder()
        .baseUrl(uri)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Bean
  public ImageApi imageApi() {
    return retrofit(imageUri).create(ImageApi.class);
  }

}
