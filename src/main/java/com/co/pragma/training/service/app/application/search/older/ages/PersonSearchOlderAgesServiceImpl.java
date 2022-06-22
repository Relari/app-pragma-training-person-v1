package com.co.pragma.training.service.app.application.search.older.ages;

import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.db.PersonDao;
import com.co.pragma.training.service.app.infrastructure.proxy.ImageDao;
import io.reactivex.Observable;
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
public class PersonSearchOlderAgesServiceImpl implements PersonSearchOlderAgesService {

    private final PersonDao personDao;
    private final ImageDao imageDao;

    @Override
    public Observable<Person> searchOlderAges(Integer age) {
        return personDao.searchOlderAges(age)
                .flatMapSingle(person -> imageDao.getImage(person.getId())
                        .map(image -> person.mutate()
                                .image(image)
                                .build()
                        )
                );
    }

}
