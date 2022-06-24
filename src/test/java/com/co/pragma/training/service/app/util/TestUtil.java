package com.co.pragma.training.service.app.util;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.domain.Person;
import com.co.pragma.training.service.app.infrastructure.controller.model.ImageRequest;
import com.co.pragma.training.service.app.infrastructure.controller.model.PersonRequest;
import com.co.pragma.training.service.app.infrastructure.db.model.PersonEntity;
import com.co.pragma.training.service.app.infrastructure.proxy.model.ImageResponse;
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

  private static final Long idPerson = 1L;
  private static final String cityBirth = "Lima - Peru";
  private static final String names = "Renzo Daniel";
  private static final String lastNames = "Lavado Rivas";
  private static final Integer age = 27;
  private static final String sex = "M";
  private static final String identificationType = "DNI";
  private static final String identificationNumber = "999999999";

  public static Person buildPerson() {
    return Person.builder()
        .id(idPerson)
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
        .image(buildImageRequest())
        .build();
  }

  public static PersonEntity buildPersonEntity() {
    return PersonEntity.builder()
        .id(idPerson)
        .names(names)
        .lastNames(lastNames)
        .age(age)
        .sex(sex)
        .cityBirth(cityBirth)
        .identificationType(identificationType)
        .identificationNumber(identificationNumber)
        .build();
  }
  private static final String content  = "lkjadlkjadflkjasdlkjasdlkjasdlkj";
  private static final String idImage  = "70a14d5e-bb62-4b8a-9582-b11d765fba4f";

  public static ImageRequest buildImageRequest() {
    return new ImageRequest(content);
  }

  public static Image buildImage() {
    return Image.of(idImage, content);
  }

  public static ImageResponse buildImageResponse() {
    return ImageResponse.builder()
            .id(idImage)
            .idPerson(idPerson)
            .content(content)
            .build();
  }
}
