package com.co.pragma.training.service.app.application.search.person;

import com.co.pragma.training.service.app.domain.Person;
import io.reactivex.Single;

/**
 * <b>Interface:</b> PersonSearchOlderAgesService.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

public interface PersonSearchService {

    Single<Person> getPerson(String type, String number);

}