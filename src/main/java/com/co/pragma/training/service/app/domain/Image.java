package com.co.pragma.training.service.app.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
public class Image {

  private String id;
  private String content;

}
