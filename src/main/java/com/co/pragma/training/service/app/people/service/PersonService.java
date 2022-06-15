package com.co.pragma.training.service.app.people.service;

import com.co.pragma.training.service.app.people.model.domain.Person;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> PersonService.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

public interface PersonService {

    Single<Person> getPerson(String type, String number);
    Observable<Person> getPeopleByAge(Integer age);
    Completable savePerson(Person person);

}