package com.co.pragma.training.service.app.people.model.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {

  private String id;
  private Long idPerson;
  private String content;

}
