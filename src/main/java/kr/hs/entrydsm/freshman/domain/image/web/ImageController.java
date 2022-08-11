package kr.hs.entrydsm.freshman.domain.image.web;

import kr.hs.entrydsm.freshman.domain.image.service.ImageService;
import kr.hs.entrydsm.freshman.domain.image.web.dto.response.ImageResponse;
import kr.hs.entrydsm.freshman.infrastructure.s3.ImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;
    private final ImageFacade imageFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/images")
    public ImageResponse imageUpload(MultipartFile image) {
        return imageService.execute(image);
    }
}
