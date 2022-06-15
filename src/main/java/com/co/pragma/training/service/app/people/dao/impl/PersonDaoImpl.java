package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.dao.PersonDao;
import com.co.pragma.training.service.app.people.dao.repository.PersonRepository;
import com.co.pragma.training.service.app.people.model.domain.Person;
import com.co.pragma.training.service.app.people.model.entity.PersonEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> PersonDaoImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Slf4j
@Component
@AllArgsConstructor
public class PersonDaoImpl implements PersonDao {

    private final PersonRepository personRepository;

    @Override
    public Single<Person> searchByDocumentTypeAndNumber(String type, String number) {
        return Single.fromCallable(() ->
                        personRepository.findByIdentificationTypeAndIdentificationNumber(
                                type, number
                        )
                )
                .subscribeOn(Schedulers.io())
                .map(PersonMapper::mapPerson);
    }

    @Override
    public Observable<Person> searchByAge(Integer age) {
        return Observable.fromCallable(() -> personRepository.getOlderPeople(age))
                .flatMapIterable(people -> people)
                .subscribeOn(Schedulers.io())
                .map(PersonMapper::mapPerson);
    }

    @Override
    public Completable savePerson(Person person) {
        return Single.fromCallable(() -> PersonMapper.mapPersonEntity(person))
                .subscribeOn(Schedulers.io())
                .map(personRepository::save)
                .ignoreElement();
    }

}
