package com.co.pragma.training.service.app.infrastructure.proxy.mapper;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.infrastructure.proxy.model.image.ImageRequest;
import com.co.pragma.training.service.app.infrastructure.proxy.model.image.ImageResponse;
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
