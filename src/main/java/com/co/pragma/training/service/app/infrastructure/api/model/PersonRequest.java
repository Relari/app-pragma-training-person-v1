
package com.co.pragma.training.service.app.infrastructure.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <b>Class:</b> PersonRequest.
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
public class PersonRequest {

    @Schema(
            description = "Nombre Completo",
            implementation = String.class,
            example = "Renzo Daniel",
            required = true
    )
    @NotBlank
    private String names;

    @Schema(
            description = "Apellidos Completos",
            implementation = String.class,
            example = "Lavado Rivas",
            required = true
    )
    @NotBlank
    private String lastNames;

    @Schema(
            description = "Genero",
            implementation = String.class,
            pattern = "[M|F]",
            example = "M",
            required = true
    )
    @NotBlank
    @Pattern(regexp = "[M|F]")
    private String sex;

    @Schema(
            description = "Edad",
            implementation = Integer.class,
            example = "20",
            required = true
    )
    @NotNull
    private Integer age;

    @Schema(
            description = "Ciudad de Nacimiento",
            implementation = String.class,
            example = "Lima - Peru",
            required = true
    )
    @NotBlank
    private String cityBirth;

    @Schema(
            description = "Tipo de Indetificacion",
            implementation = String.class,
            example = "DNI",
            required = true
    )
    @NotBlank
    private String identificationType;

    @Schema(
            description = "Numero de Indetificacion",
            implementation = String.class,
            example = "99999999",
            required = true
    )
    @NotBlank
    @Pattern(regexp = "[0-9]*")
    private String identificationNumber;

    @NotNull
    private ImageRequest image;

}