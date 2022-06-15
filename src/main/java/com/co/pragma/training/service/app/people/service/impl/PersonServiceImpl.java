package com.co.pragma.training.service.app.people.service.impl;

import com.co.pragma.training.service.app.people.dao.PersonDao;
import com.co.pragma.training.service.app.people.model.domain.Person;
import com.co.pragma.training.service.app.people.service.PersonService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> PersonServiceImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public Single<Person> getPerson(String type, String number) {
        return personDao.searchByDocumentTypeAndNumber(type, number);
    }

    @Override
    public Observable<Person> getPeopleByAge(Integer age) {
        return personDao.searchByAge(age);
    }

    @Override
    public Completable savePerson(Person person) {
        return personDao.savePerson(person);
    }

}
