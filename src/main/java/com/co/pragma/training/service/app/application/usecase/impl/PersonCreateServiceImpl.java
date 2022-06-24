package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonCreateService;
import com.co.pragma.training.service.app.domain.Person;
import io.reactivex.Completable;
import lombok.AllArgsConstructor;

/**
 * <b>Class:</b> PersonSearchOlderAgesServiceImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@AllArgsConstructor
public class PersonCreateServiceImpl implements PersonCreateService {

    private final PersonDao personDao;
    private final ImageDao imageDao;

    @Override
    public Completable savePerson(Person person) {
        return personDao.savePerson(person)
                .flatMapCompletable(idPerson ->
                        imageDao.save(idPerson, person.getImage().getContent())
                );
    }

}
