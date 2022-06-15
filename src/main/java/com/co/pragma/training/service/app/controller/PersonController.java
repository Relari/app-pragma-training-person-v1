package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.people.model.api.PersonRequest;
import com.co.pragma.training.service.app.people.model.api.PersonResponse;
import com.co.pragma.training.service.app.people.service.PersonService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * <b>Class:</b> PersonController.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Single<PersonResponse> getPerson(
            @RequestParam(value = "documentType") String type,
            @RequestParam(value = "documentNumber") String documentNumber) {

        return personService.getPerson(type, documentNumber)
                .map(PersonMapper::mapPersonResponse);
    }

    @GetMapping(path = "/{age}/older")
    public Observable<PersonResponse> getPeopleByAge(
            @Pattern(regexp = "[0-9]*")
            @PathVariable Integer age) {
        return personService.getPeopleByAge(age)
                .map(PersonMapper::mapPersonResponse);
    }

    @PostMapping
    public Completable savePerson(
            @RequestBody PersonRequest personRequest) {
        return Single.fromCallable(() -> PersonMapper.mapPerson(personRequest))
                .flatMapCompletable(personService::savePerson);
    }

}
