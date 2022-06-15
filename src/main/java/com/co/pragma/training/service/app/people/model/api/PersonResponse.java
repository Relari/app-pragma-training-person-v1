
package com.co.pragma.training.service.app.people.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <b>Class:</b> PersonResponse.
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
public class PersonResponse {

    @Schema(
            description = "Identificador del Registro",
            implementation = Long.class,
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Nombre Completo",
            implementation = String.class,
            example = "Renzo Daniel"
    )
    private String names;

    @Schema(
            description = "Apellidos Completos",
            implementation = String.class,
            example = "Lavado Rivas"
    )
    private String lastNames;

    @Schema(
            description = "Genero",
            implementation = String.class,
            pattern = "[M|F]",
            example = "M"
    )
    private String sex;

    @Schema(
            description = "Edad",
            implementation = Integer.class,
            example = "20"
    )
    private Integer age;

    @Schema(
            description = "Ciudad de Nacimiento",
            implementation = String.class,
            example = "Lima - Peru"
    )
    private String cityBirth;

    @Schema(
            description = "Tipo de Indetificacion",
            implementation = String.class,
            example = "DNI"
    )
    private String identificationType;

    @Schema(
            description = "Numero de Indetificacion",
            implementation = String.class,
            example = "99999999"
    )
    private String identificationNumber;

}