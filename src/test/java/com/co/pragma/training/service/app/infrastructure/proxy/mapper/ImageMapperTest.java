package com.co.pragma.training.service.app.infrastructure.proxy.mapper;

import com.co.pragma.training.service.app.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageMapperTest {

  @Test
  void testMapImage() {

    var imageEntity = TestUtil.buildImageResponse();
    var image = ImageMapper.mapImage(imageEntity);

    assertEquals(imageEntity.getId(), image.getId());
    assertEquals(imageEntity.getContent(), image.getContent());

  }

  @Test
  void testMapImageEntity() {

    var idPerson = 1L;
    var content = "content";

    var imageEntity = ImageMapper.mapImageEntity(idPerson, content);

    assertEquals(idPerson, imageEntity.getIdPerson());
    assertEquals(content, imageEntity.getContent());

  }

}
