package com.co.pragma.training.service.app.people.dao.repository;

import com.co.pragma.training.service.app.people.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>Interface:</b> PersonRepository.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOL&Oacute;GICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByIdentificationTypeAndIdentificationNumber(
            String identificationType, String identificationNumber
    );

    @Query(value = "SELECT * FROM PERSON WHERE AGE >= :age", nativeQuery = true)
    List<PersonEntity> getOlderPeople(
            @Param("age") Integer age
    );

}
