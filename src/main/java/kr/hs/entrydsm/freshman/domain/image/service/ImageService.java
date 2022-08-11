package kr.hs.entrydsm.freshman.domain.image.service;

import kr.hs.entrydsm.freshman.domain.image.exception.ImageNotFoundException;
import kr.hs.entrydsm.freshman.domain.image.web.dto.response.ImageResponse;
import kr.hs.entrydsm.freshman.infrastructure.s3.ImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageFacade imageFacade;

    public ImageResponse execute(MultipartFile image) {
        if (image == null || image.isEmpty() || image.getOriginalFilename() == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String imageUrl = imageFacade.upload(image);
        return new ImageResponse(imageUrl);
    }
}
