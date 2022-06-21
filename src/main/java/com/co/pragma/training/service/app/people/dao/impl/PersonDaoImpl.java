package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.dao.PersonDao;
import com.co.pragma.training.service.app.people.dao.repository.PersonRepository;
import com.co.pragma.training.service.app.people.model.domain.Person;
import com.co.pragma.training.service.app.people.model.entity.PersonEntity;
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
                .map(PersonMapper::mapPerson)
                .doOnSubscribe(disposable ->
                        log.debug("Search for the person in the database. [type={}, number={}]", type, number)
                )
                .doOnError(throwable ->
                        log.error("An error occurred when searching for the person in the database. [type={}, number={}]", type, number)
                )
                .doOnSuccess(person ->
                        log.debug("Person found in the database. [type={}, number={}]", type, number)
                );
    }

    @Override
    public Observable<Person> searchByAge(Integer age) {
        return Observable.fromCallable(() -> personRepository.getOlderPeople(age))
                .flatMapIterable(people -> people)
                .subscribeOn(Schedulers.io())
                .map(PersonMapper::mapPerson);
    }

    @Override
    public Single<Long> savePerson(Person person) {
        return Single.fromCallable(() -> PersonMapper.mapPersonEntity(person))
                .subscribeOn(Schedulers.io())
                .map(personRepository::save)
                .map(PersonEntity::getId)
                .doOnSubscribe(disposable ->
                        log.debug("Save the person in the database. [type={}, number={}]",
                                person.getIdentificationType(), person.getIdentificationNumber()
                        )
                )
                .doOnError(throwable ->
                        log.error("An error occurred while saving the person in the database. [type={}, number={}]",
                                person.getIdentificationType(), person.getIdentificationNumber()
                        )
                )
                .doOnSuccess(idPerson ->
                        log.debug("Person saved in the database. [idPerson={}]", idPerson)
                );
    }

}
