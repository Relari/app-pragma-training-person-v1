package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.people.model.api.ImageResponse;
import com.co.pragma.training.service.app.people.model.api.PersonRequest;
import com.co.pragma.training.service.app.people.model.api.PersonResponse;
import com.co.pragma.training.service.app.people.model.domain.Image;
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

    private static final String EMPTY = "";

    static PersonResponse mapPersonResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .sex(person.getSex())
                .age(person.getAge())
                .cityBirth(person.getCityBirth())
                .identificationType(person.getIdentificationType())
                .identificationNumber(person.getIdentificationNumber())
                .image(new ImageResponse(
                        person.getImage().getId(),
                        person.getImage().getContent())
                )
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
                .image(Image.of(EMPTY, personRequest.getImage().getContent()))
                .build();
    }
}
