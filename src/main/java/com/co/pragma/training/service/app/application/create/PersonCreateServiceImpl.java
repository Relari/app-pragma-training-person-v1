package com.co.pragma.training.service.app.application.create;

import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.db.PersonDao;
import com.co.pragma.training.service.app.infrastructure.proxy.ImageDao;
import io.reactivex.Completable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> PersonSearchOlderAgesServiceImpl.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Service
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
