package com.co.pragma.training.service.app.infrastructure.proxy.model.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest {

  private Long idPerson;
  private String content;

}
