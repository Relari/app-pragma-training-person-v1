package com.co.pragma.training.service.app.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <b>Class:</b> PersonEntity.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Entity
@Table(name = "PERSON")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "lastNames", nullable = false)
    private String lastNames;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "cityBirth", nullable = false)
    private String cityBirth;

    @Column(name = "identificationType", nullable = false)
    private String identificationType;

    @Column(name = "identificationNumber", nullable = false)
    private String identificationNumber;


}
