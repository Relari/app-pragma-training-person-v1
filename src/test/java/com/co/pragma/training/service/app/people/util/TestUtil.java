package com.co.pragma.training.service.app.people.util;

import com.co.pragma.training.service.app.people.model.api.PersonRequest;
import com.co.pragma.training.service.app.people.model.domain.Person;
import com.co.pragma.training.service.app.people.model.entity.PersonEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <b>Class:</b> TestUtil.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

  private static final Long idEmployee = 1L;
  private static final String cityBirth = "Lima - Peru";
  private static final String names = "Renzo Daniel";
  private static final String lastNames = "Lavado Rivas";
  private static final Integer age = 27;
  private static final String sex = "M";
  private static final String identificationType = "DNI";
  private static final String identificationNumber = "999999999";

  public static Person buildPerson() {
    return Person.builder()
        .id(idEmployee)
        .names(names)
        .lastNames(lastNames)
        .age(age)
        .sex(sex)
        .cityBirth(cityBirth)
        .identificationType(identificationType)
        .identificationNumber(identificationNumber)
        .build();
  }

  public static PersonRequest buildPersonRequest() {
    return PersonRequest.builder()
        .names(names)
        .lastNames(lastNames)
        .age(age)
        .sex(sex)
        .cityBirth(cityBirth)
        .identificationType(identificationType)
        .identificationNumber(identificationNumber)
        .build();
  }

  public static PersonEntity buildPersonEntity() {
    return PersonEntity.builder()
        .names(names)
        .lastNames(lastNames)
        .age(age)
        .sex(sex)
        .cityBirth(cityBirth)
        .identificationType(identificationType)
        .identificationNumber(identificationNumber)
        .build();
  }
}
