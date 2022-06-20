package com.co.pragma.training.service.app.people.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
public class Image {

  private String id;
  private String content;

}
