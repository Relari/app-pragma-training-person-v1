package com.co.pragma.training.service.app.infrastructure.db.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.co.pragma.training.service.app.util.TestUtil;
import org.junit.jupiter.api.Test;

/**
 * <b>Class:</b> PersonMapperTest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

class PersonMapperTest {

  @Test
  void mapEmployee() {

    var personEntity = TestUtil.buildPersonEntity();

    var person = PersonMapper.mapPerson(personEntity);

    assertEquals(personEntity.getNames(), person.getNames());
    assertEquals(personEntity.getLastNames(), person.getLastNames());
    assertEquals(personEntity.getAge(), person.getAge());
    assertEquals(personEntity.getSex(), person.getSex());
    assertEquals(personEntity.getIdentificationType(), person.getIdentificationType());
    assertEquals(personEntity.getIdentificationNumber(), person.getIdentificationNumber());

  }

  @Test
  void mapPersonEntity() {

    var person = TestUtil.buildPerson();
    var personEntity = PersonMapper.mapPersonEntity(person);

    assertEquals(person.getNames(), personEntity.getNames());
    assertEquals(person.getLastNames(), personEntity.getLastNames());
    assertEquals(person.getAge(), personEntity.getAge());
    assertEquals(person.getSex(), personEntity.getSex());
    assertEquals(person.getIdentificationType(), personEntity.getIdentificationType());
    assertEquals(person.getIdentificationNumber(), personEntity.getIdentificationNumber());
  }

}
