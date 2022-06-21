package com.co.pragma.training.service.app.people.service.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.people.dao.ImageDao;
import com.co.pragma.training.service.app.people.util.TestUtil;
import com.co.pragma.training.service.app.people.dao.PersonDao;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <b>Class:</b> PersonServiceTest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

  @Mock
  private PersonDao personDao;

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private PersonServiceImpl personService;

//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeDao.findAll())
//        .thenReturn(Observable.just(TestUtil.employee()));
//
//    TestObserver<Employee> testObserver = employeeService.findAll().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    var person = TestUtil.buildPerson()
            .mutate()
            .image(TestUtil.buildImage())
            .build();

    when(personDao.savePerson(any()))
        .thenReturn(Single.just(person.getId()));

    when(imageDao.save(anyLong(), anyString()))
        .thenReturn(Completable.complete());

    var testObserver = personService.savePerson(person).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    var person = TestUtil.buildPerson();

    when(personDao.searchByDocumentTypeAndNumber(anyString(), anyString()))
        .thenReturn(Single.just(person));

    var image = TestUtil.buildImage();

    when(imageDao.getImage(anyLong()))
        .thenReturn(Single.just(image));

    var testObserver = personService.getPerson(
            person.getIdentificationType(),
            person.getIdentificationNumber()
    ).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personDomain ->
                personDomain.getId().equals(person.getId())
        )
        .assertValue(personDomain ->
                personDomain.getNames().equals(person.getNames())
        )
        .assertValue(personDomain ->
                personDomain.getLastNames().equals(person.getLastNames())
        )
        .assertValue(personDomain ->
                personDomain.getAge().equals(person.getAge())
        )
        .assertValue(personDomain ->
                personDomain.getSex().equals(person.getSex())
        )
        .assertValue(personDomain ->
                personDomain.getCityBirth().equals(person.getCityBirth())
        )
        .assertValue(personDomain ->
                personDomain.getIdentificationType().equals(person.getIdentificationType())
        )
        .assertValue(personDomain ->
                personDomain.getIdentificationNumber().equals(person.getIdentificationNumber())
        );
  }

    @Test
    void whenFindByAgeThenReturnPeople() {

        var person = TestUtil.buildPerson();

        when(personDao.searchByAge(anyInt()))
                .thenReturn(Observable.just(person));

        var image = TestUtil.buildImage();

        when(imageDao.getImage(anyLong()))
                .thenReturn(Single.just(image));

        var testObserver = personService.getPeopleByAge(
                person.getAge()
        ).test();

        testObserver.awaitTerminalEvent();

        testObserver.assertComplete().assertNoErrors()
                .assertValueAt(0, personDomain ->
                        personDomain.getId().equals(person.getId())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getNames().equals(person.getNames())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getLastNames().equals(person.getLastNames())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getAge().equals(person.getAge())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getSex().equals(person.getSex())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getCityBirth().equals(person.getCityBirth())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getIdentificationType().equals(person.getIdentificationType())
                )
                .assertValueAt(0, personDomain ->
                        personDomain.getIdentificationNumber().equals(person.getIdentificationNumber())
                );
    }

}
