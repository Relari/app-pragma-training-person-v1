package com.co.pragma.training.service.app.people.dao;

import com.co.pragma.training.service.app.people.model.domain.Person;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> PersonDao.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

public interface PersonDao {

    Single<Person> searchByDocumentTypeAndNumber(String type, String number);

    Observable<Person> searchByAge(Integer age);

    Single<Long> savePerson(Person person);

}
