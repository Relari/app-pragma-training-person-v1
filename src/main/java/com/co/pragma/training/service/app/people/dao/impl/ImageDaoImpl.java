package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.dao.ImageDao;
import com.co.pragma.training.service.app.people.dao.proxy.ImageApi;
import com.co.pragma.training.service.app.people.model.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ImageDaoImpl implements ImageDao {

  private final ImageApi imageApi;

  @Override
  public Completable save(Long idPerson, String content) {
    return Single.fromCallable(() -> ImageMapper.mapImageEntity(idPerson, content))
            .flatMapCompletable(imageApi::save)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(disposable ->
                    log.debug("Starting to save the image of the person.")
            )
            .doOnError(throwable ->
                    log.error("An error occurred while saving the image of the person.", throwable)
            )
            .doOnComplete(() ->
                    log.debug("Image of the person saved successfully.")
            );
  }

  @Override
  public Observable<Image> getImages() {
    return imageApi.getImages()
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage);
  }

  @Override
  public Single<Image> getImage(Long id) {
    return imageApi.getImage(id)
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage)
            .doOnSubscribe(disposable ->
                    log.debug("Find the image of the person. [idPerson={}]", id)
            )
            .doOnError(throwable ->
                    log.error("An error occurred while searching for the person's image. [idPerson={}]", id, throwable)
            )
            .doOnSuccess(image ->
                    log.debug("Image of the person found. [idPerson={}]", id)
            );
  }

}
