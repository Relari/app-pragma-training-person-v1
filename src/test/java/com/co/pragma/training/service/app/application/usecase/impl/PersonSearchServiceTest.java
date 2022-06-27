package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.usecase.impl.PersonSearchServiceImpl;
import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * <b>Class:</b> PersonSearchOlderAgesServiceImplTest.
 * <b>Company:</b> PRAGMA SOLUCIONES TECNOLÓGICAS PERU S.A.C.
 *
 * @author RLR
 * @version 1.0.0
 */

@ExtendWith(MockitoExtension.class)
class PersonSearchServiceTest {

  @Mock
  private PersonDao personDao;

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private PersonSearchServiceImpl personService;

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

}
