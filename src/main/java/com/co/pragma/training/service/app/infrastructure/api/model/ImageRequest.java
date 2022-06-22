package com.co.pragma.training.service.app.infrastructure.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest {

  @NotBlank
  private String content;

}
