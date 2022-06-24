package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Person;
import io.reactivex.Observable;

/**
 * <b>Interface:</b> PersonSearchOlderAgesService.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

public interface PersonSearchOlderAgesService {

    Observable<Person> searchOlderAges(Integer age);

}