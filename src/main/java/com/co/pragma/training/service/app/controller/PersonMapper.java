package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.people.model.api.PersonRequest;
import com.co.pragma.training.service.app.people.model.api.PersonResponse;
import com.co.pragma.training.service.app.people.model.domain.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <b>Class:</b> PersonMapper.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PersonMapper {

    static PersonResponse mapPersonResponse(Person person) {
        return PersonResponse.builder()
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .sex(person.getSex())
                .age(person.getAge())
                .cityBirth(person.getCityBirth())
                .identificationType(person.getIdentificationType())
                .identificationNumber(person.getIdentificationNumber())
                .build();
    }

    static Person mapPerson(PersonRequest personRequest) {
        return Person.builder()
                .names(personRequest.getNames())
                .lastNames(personRequest.getLastNames())
                .sex(personRequest.getSex())
                .age(personRequest.getAge())
                .cityBirth(personRequest.getCityBirth())
                .identificationType(personRequest.getIdentificationType())
                .identificationNumber(personRequest.getIdentificationNumber())
                .build();
    }
}
