package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.people.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    var personRequest = TestUtil.buildPersonRequest();

    var person = PersonMapper.mapPerson(personRequest);

    assertEquals(personRequest.getNames(), person.getNames());
    assertEquals(personRequest.getLastNames(), person.getLastNames());
    assertEquals(personRequest.getAge(), person.getAge());
    assertEquals(personRequest.getSex(), person.getSex());
    assertEquals(personRequest.getIdentificationType(), person.getIdentificationType());
    assertEquals(personRequest.getIdentificationNumber(), person.getIdentificationNumber());

  }

  @Test
  void mapPersonResponseTest() {

    var person = TestUtil.buildPerson();
    var personResponse = PersonMapper.mapPersonResponse(person);

    assertEquals(person.getNames(), personResponse.getNames());
    assertEquals(person.getLastNames(), personResponse.getLastNames());
    assertEquals(person.getAge(), personResponse.getAge());
    assertEquals(person.getSex(), personResponse.getSex());
    assertEquals(person.getIdentificationType(), personResponse.getIdentificationType());
    assertEquals(person.getIdentificationNumber(), personResponse.getIdentificationNumber());
  }

}
