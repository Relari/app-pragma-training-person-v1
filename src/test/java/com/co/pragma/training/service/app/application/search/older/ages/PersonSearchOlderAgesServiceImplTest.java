package com.co.pragma.training.service.app.application.search.older.ages;

import com.co.pragma.training.service.app.infrastructure.db.PersonDao;
import com.co.pragma.training.service.app.infrastructure.proxy.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Observable;
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
class PersonSearchOlderAgesServiceImplTest {

  @Mock
  private PersonDao personDao;

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private PersonSearchOlderAgesServiceImpl personService;

    @Test
    void whenFindByAgeThenReturnPeople() {

        var person = TestUtil.buildPerson();

        when(personDao.searchOlderAges(anyInt()))
                .thenReturn(Observable.just(person));

        var image = TestUtil.buildImage();

        when(imageDao.getImage(anyLong()))
                .thenReturn(Single.just(image));

        var testObserver = personService.searchOlderAges(
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
