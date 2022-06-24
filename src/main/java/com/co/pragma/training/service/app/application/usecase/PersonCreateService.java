package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Person;
import io.reactivex.Completable;

public interface PersonCreateService {

    Completable savePerson(Person person);

}
