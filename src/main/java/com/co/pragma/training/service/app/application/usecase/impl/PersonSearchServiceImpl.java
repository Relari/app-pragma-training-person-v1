package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.usecase.PersonSearchService;
import com.co.pragma.training.service.app.domain.Person;
import io.reactivex.Single;
import lombok.AllArgsConstructor;

/**
 * <b>Class:</b> PersonSearchOlderAgesServiceImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@AllArgsConstructor
public class PersonSearchServiceImpl implements PersonSearchService {

    private final PersonDao personDao;
    private final ImageDao imageDao;

    @Override
    public Single<Person> getPerson(String type, String number) {
        return personDao.searchByDocumentTypeAndNumber(type, number)
                .flatMap(person -> imageDao.getImage(person.getId())
                        .map(image -> person.mutate()
                                .image(image)
                                .build()
                        )
                );
    }

}
