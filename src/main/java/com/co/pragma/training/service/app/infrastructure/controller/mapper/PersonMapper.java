package com.co.pragma.training.service.app.infrastructure.controller.mapper;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.controller.model.ImageResponse;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonResponse;
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
public class PersonMapper {

    private static final String EMPTY = "";

    public static PersonResponse mapPersonResponse(Person person) {
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

    public static Person mapPerson(PersonRequest personRequest) {
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
