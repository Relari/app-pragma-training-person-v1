package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.people.model.api.PersonRequest;
import com.co.pragma.training.service.app.people.model.api.PersonResponse;
import com.co.pragma.training.service.app.people.service.PersonService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * <b>Class:</b> PersonController.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Tag(name = "Person", description = "Person Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Person API",
                version = "${application.info.version}",
                description = "${application.info.description}"
        )
)

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @Operation(
            summary = "Obtiene la informacion de un estudiante.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Students",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = PersonResponse.class)
                            )
                    )
            })
    @GetMapping
    public Single<PersonResponse> getPerson(
            @Parameter(
                    description = "Tipo de Identificaci&oacute;n",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            implementation = String.class
                    ),
                    example = "DNI",
                    required = true
            )
            @RequestParam(value = "documentType") String documentType,
            @Parameter(
                    description = "Numero de Identificaci&oacute;n",
                    in = ParameterIn.QUERY,
                    schema = @Schema(
                            pattern = "[0-9]*",
                            implementation = String.class
                    ),
                    example = "99999999",
                    required = true
            )
            @Pattern(regexp = "[0-9]*")
            @RequestParam(value = "documentNumber") String documentNumber) {

        return personService.getPerson(documentType, documentNumber)
                .map(PersonMapper::mapPersonResponse);
    }

    @Operation(
            summary = "Obtiene la informacion de un estudiante.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Students",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = PersonResponse.class)
                                    )
                            )
                    )
            })
    @GetMapping(path = "/{age}/older")
    public Observable<PersonResponse> getPeopleByAge(
            @Parameter(
                    description = "Edad",
                    in = ParameterIn.PATH,
                    schema = @Schema(
                            pattern = "[0-9]*",
                            implementation = Integer.class
                    ),
                    example = "1",
                    required = true
            )
            @Pattern(regexp = "[0-9]*")
            @PathVariable("age") Integer age) {
        return personService.getPeopleByAge(age)
                .map(PersonMapper::mapPersonResponse);
    }

    @Operation(
            summary = "Guarda al empleado",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Create Successful"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error to Save",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Throwable.class)
                            )
                    )
            })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Completable savePerson(
            @RequestBody PersonRequest personRequest) {
        return Single.fromCallable(() -> PersonMapper.mapPerson(personRequest))
                .flatMapCompletable(personService::savePerson);
    }

}
