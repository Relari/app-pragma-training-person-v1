package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.model.domain.Person;
import com.co.pragma.training.service.app.people.model.entity.PersonEntity;
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

    static PersonEntity mapPersonEntity(Person person) {
        return PersonEntity.builder()
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .sex(person.getSex())
                .age(person.getAge())
                .cityBirth(person.getCityBirth())
                .identificationType(person.getIdentificationType())
                .identificationNumber(person.getIdentificationNumber())
                .build();
    }

    static Person mapPerson(PersonEntity personEntity) {
        return Person.builder()
                .names(personEntity.getNames())
                .lastNames(personEntity.getLastNames())
                .sex(personEntity.getSex())
                .age(personEntity.getAge())
                .cityBirth(personEntity.getCityBirth())
                .identificationType(personEntity.getIdentificationType())
                .identificationNumber(personEntity.getIdentificationNumber())
                .build();
    }

}
