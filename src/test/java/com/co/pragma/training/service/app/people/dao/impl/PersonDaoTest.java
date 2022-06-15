package com.co.pragma.training.service.app.people.dao.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.people.util.TestUtil;
import com.co.pragma.training.service.app.people.dao.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

/**
 * <b>Class:</b> PersonDaoTest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@ExtendWith(MockitoExtension.class)
class PersonDaoTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonDaoImpl personDao;

//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    when(personRepository.findAll())
//        .thenReturn(Collections.singletonList(TestUtil.employeeEntity()));
//
//    TestObserver<Employee> testObserver = employeeDao.findAll().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    var personEntity = TestUtil.buildPersonEntity();

    when(personRepository.findByIdentificationTypeAndIdentificationNumber(anyString(), anyString()))
        .thenReturn(personEntity);

    var testObserver = personDao.searchByDocumentTypeAndNumber(
            personEntity.getIdentificationType(),
            personEntity.getIdentificationNumber()
    ).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
            .assertValue(person ->
                    person.getNames().equals(personEntity.getNames())
            )
            .assertValue(person ->
                    person.getLastNames().equals(personEntity.getLastNames())
            )
            .assertValue(person ->
                    person.getAge().equals(personEntity.getAge())
            )
            .assertValue(person ->
                    person.getSex().equals(personEntity.getSex())
            )
            .assertValue(person ->
                    person.getCityBirth().equals(personEntity.getCityBirth())
            )
            .assertValue(person ->
                    person.getIdentificationType().equals(personEntity.getIdentificationType())
            )
            .assertValue(person ->
                    person.getIdentificationNumber().equals(personEntity.getIdentificationNumber())
            );

  }

    @Test
    void whenFindByAgeThenReturnPeople() {

        var personEntity = TestUtil.buildPersonEntity();

        when(personRepository.getOlderPeople(anyInt()))
                .thenReturn(Collections.singletonList(personEntity));

        var testObserver = personDao.searchByAge(
                personEntity.getAge()
        ).test();

        testObserver.awaitTerminalEvent();

        testObserver.assertComplete().assertNoErrors()
                .assertValueAt(0, person ->
                        person.getNames().equals(personEntity.getNames())
                )
                .assertValueAt(0, person ->
                        person.getLastNames().equals(personEntity.getLastNames())
                )
                .assertValueAt(0, person ->
                        person.getAge().equals(personEntity.getAge())
                )
                .assertValueAt(0, person ->
                        person.getSex().equals(personEntity.getSex())
                )
                .assertValueAt(0, person ->
                        person.getCityBirth().equals(personEntity.getCityBirth())
                )
                .assertValueAt(0, person ->
                        person.getIdentificationType().equals(personEntity.getIdentificationType())
                )
                .assertValueAt(0, person ->
                        person.getIdentificationNumber().equals(personEntity.getIdentificationNumber())
                );

    }

  @Test
  void whenSaveEmployeeThenReturnEmployee() {

    when(personRepository.save(any()))
        .thenReturn(TestUtil.buildPersonEntity());

    var testObserver = personDao.savePerson(TestUtil.buildPerson()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

//  @Test
//  void whenFindByIdThenReturnEmpty() {
//
//    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
//            .thenReturn(Optional.empty());
//
//    TestObserver<Employee> testObserver = employeeDao.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnError() {
//
//    Mockito.when(errorFactory.buildException(Mockito.any(), Mockito.any()))
//            .thenReturn(new RuntimeException());
//
//    Mockito.when(employeeRepository.save(Mockito.any()))
//            .thenReturn(new Throwable());
//
//    TestObserver<Void> testObserver = employeeDao.save(TestUtil.employee()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
//  private RuntimeException employeeException() {
//    return errorFactory.buildException(ErrorCategory.EMPLOYEE_NOT_SAVE, null);
//  }

}
