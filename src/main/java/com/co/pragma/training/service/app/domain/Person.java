
package com.co.pragma.training.service.app.domain;

import lombok.*;

/**
 * <b>Class:</b> Person.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

    private Long id;
    private String names;
    private String lastNames;
    private String sex;
    private Integer age;
    private String cityBirth;
    private String identificationType;
    private String identificationNumber;
    private Image image;

    /**
     * mutate.
     * @return {@link PersonBuilder}
     */
    public PersonBuilder mutate() {
        return Person.builder()
                .id(id)
                .names(names)
                .lastNames(lastNames)
                .sex(sex)
                .age(age)
                .cityBirth(cityBirth)
                .identificationType(identificationType)
                .identificationNumber(identificationNumber)
                .image(image);
    }
}