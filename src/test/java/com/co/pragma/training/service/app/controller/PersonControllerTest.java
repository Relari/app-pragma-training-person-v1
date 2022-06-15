package com.co.pragma.training.service.app.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.people.service.PersonService;
import com.co.pragma.training.service.app.people.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <b>Class:</b> PersonControllerTest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

  @Mock
  private PersonService personService;

  @InjectMocks
  private PersonController personController;

//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeService.findAll())
//        .thenReturn(Observable.just(TestUtil.employee()));
//
//    TestObserver<PersonResponse> testObserver = employeeController.listOfEmployees().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(personResponse -> personResponse.getFirstName().equals(TestConstant.nombre))
//        .assertValue(personResponse -> personResponse.getFatherLastName().equals(TestConstant.apellidoPaterno))
//        .assertValue(personResponse -> personResponse.getMotherLastName().equals(TestConstant.apellidoMaterno))
//        .assertValue(personResponse -> personResponse.getSex().equals(TestConstant.sexo));
//
//  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {
    when(personService.savePerson(any()))
        .thenReturn(Completable.complete());

    var testObserver =
        personController.savePerson(TestUtil.buildPersonRequest()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    var person = TestUtil.buildPerson();

    when(personService.getPerson(anyString(), anyString()))
        .thenReturn(Single.just(person));

    var testObserver = personController.getPerson(
            person.getIdentificationType(),
            person.getIdentificationNumber()
    ).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personResponse ->
                personResponse.getNames().equals(person.getNames())
        )
        .assertValue(personResponse ->
                personResponse.getLastNames().equals(person.getLastNames())
        )
        .assertValue(personResponse ->
                personResponse.getAge().equals(person.getAge())
        )
        .assertValue(personResponse ->
                personResponse.getSex().equals(person.getSex())
        )
        .assertValue(personResponse ->
                personResponse.getCityBirth().equals(person.getCityBirth())
        )
        .assertValue(personResponse ->
                personResponse.getIdentificationType().equals(person.getIdentificationType())
        )
        .assertValue(personResponse ->
                personResponse.getIdentificationNumber().equals(person.getIdentificationNumber())
        );

  }

    @Test
    void whenFindByAgeThenReturnPeople() {

        var person = TestUtil.buildPerson();

        when(personService.getPeopleByAge(anyInt()))
                .thenReturn(Observable.just(person));

        var testObserver = personController.getPeopleByAge(
                person.getAge()
        ).test();

        testObserver.awaitTerminalEvent();

        testObserver.assertComplete().assertNoErrors()
                .assertValueAt(0, personResponse ->
                        personResponse.getNames().equals(person.getNames())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getLastNames().equals(person.getLastNames())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getAge().equals(person.getAge())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getSex().equals(person.getSex())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getCityBirth().equals(person.getCityBirth())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getIdentificationType().equals(person.getIdentificationType())
                )
                .assertValueAt(0, personResponse ->
                        personResponse.getIdentificationNumber().equals(person.getIdentificationNumber())
                );

    }

}
