package com.co.pragma.training.service.app.application.dao;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface ImageDao {

  Completable save(Long idPerson, String content);

  Single<Image> getImage(Long id);

}
