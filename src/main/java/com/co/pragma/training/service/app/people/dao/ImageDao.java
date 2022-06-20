package com.co.pragma.training.service.app.people.dao;

import com.co.pragma.training.service.app.people.model.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ImageDao {

  Completable save(Long idPerson, String content);

  Observable<Image> getImages();

  Single<Image> getImage(Long id);

}
