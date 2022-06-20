package com.co.pragma.training.service.app.people.dao.impl;

import com.co.pragma.training.service.app.people.model.domain.Image;
import com.co.pragma.training.service.app.people.model.external.ImageRequest;
import com.co.pragma.training.service.app.people.model.external.ImageResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageMapper {

    public static Image mapImage(ImageResponse imageResponse) {
        return Image.of(imageResponse.getId(), imageResponse.getContent());
    }

    public static ImageRequest mapImageEntity(Long idPerson, String content) {
        return new ImageRequest(idPerson, content);
    }
}
