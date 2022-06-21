package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.dao.proxy.ImageApi;
import com.co.pragma.training.service.app.people.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Single;
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

  @InjectMocks
  private ImageDaoImpl imageDao;

//  @Test
//  void whenGetAllEmployeesThenReturnEmployees() {
//
//    var imageEntity = TestUtil.buildImageEntity();
//
//    when(imageRepository.findAll())
//            .thenReturn(Flux.just(imageEntity));
//
//    var testObserver = employeeDao.getImages().test();
//    testObserver.awaitTerminalEvent();
//    testObserver.assertComplete().assertNoErrors()
//            .assertValueAt(0, image ->
//                    image.getId().equals(imageEntity.getId())
//            )
//            .assertValueAt(0, image ->
//                    image.getIdPerson().equals(imageEntity.getIdPerson())
//            )
//            .assertValueAt(0, image ->
//                    image.getContent().equals(imageEntity.getContent())
//            );
//  }

  @Test
  void whenSearchEmployeeThenReturnEmployee() {

    var imageResponse = TestUtil.buildImageResponse();

    when(imageApi.getImage(anyLong()))
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
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageApi.save(any()))
            .thenReturn(Completable.complete());

    var idPerson = 1L;
    var content = "content";

    var testObserver = imageDao.save(idPerson, content).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }


}
