package com.co.pragma.training.service.app.infrastructure.proxy;

import com.co.pragma.training.service.app.infrastructure.config.spring.HeaderApplication;
import com.co.pragma.training.service.app.infrastructure.proxy.api.ImageApi;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Single;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageDaoImplTest {

  @Mock
  private ImageApi imageApi;

  @Mock
  private HeaderApplication headerApplication;

  @InjectMocks
  private ImageDaoImpl imageDao;

  @BeforeEach
  void init() {
    when(headerApplication.getBearerToken())
            .thenReturn("Bearer accessToken");
  }

  @Test
  void whenSearchEmployeeThenReturnImage() {

    var imageResponse = TestUtil.buildImageResponse();

    when(imageApi.getImage(anyString(), anyLong()))
            .thenReturn(Single.just(imageResponse));

    var testObserver = imageDao.getImage(imageResponse.getIdPerson()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValue(image ->
                    image.getId().equals(imageResponse.getId())
            )
            .assertValue(image ->
                    image.getContent().equals(imageResponse.getContent())
            );
  }

  @Test
  void whenSearchEmployeeThenReturnError() {

    when(imageApi.getImage(anyString(), anyLong()))
            .thenReturn(Single.error(new Throwable()));

    var idPerson = 1L;

    var testObserver = imageDao.getImage(idPerson).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertNotComplete().assertError(Throwable.class);
  }

  @Test
  void whenSaveImageThenReturnSuccessful() {

    when(imageApi.save(anyString(), any()))
            .thenReturn(Completable.complete());

    var idPerson = 1L;
    var content = "content";

    var testObserver = imageDao.save(idPerson, content).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }

  @Test
  void whenSaveImageThenReturnError() {

    when(imageApi.save(anyString(), any()))
            .thenReturn(Completable.error(new RuntimeException()));

    var idPerson = 1L;
    var content = "content";

    var testObserver = imageDao.save(idPerson, content).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertNotComplete().assertError(RuntimeException.class);
  }

}
