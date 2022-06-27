package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.usecase.impl.PersonCreateServiceImpl;
import com.co.pragma.training.service.app.application.dao.PersonDao;
import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Completable;
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
class PersonCreateServiceTest {

  @Mock
  private PersonDao personDao;

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private PersonCreateServiceImpl personService;

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

}
