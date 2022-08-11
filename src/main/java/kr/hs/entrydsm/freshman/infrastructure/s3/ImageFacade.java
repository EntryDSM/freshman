package kr.hs.entrydsm.freshman.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import kr.hs.entrydsm.freshman.domain.image.exception.ImageNotFoundException;
import kr.hs.entrydsm.freshman.domain.image.exception.InvalidImageExtensionFormatException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ImageFacade {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile multipartFile) {
        String extension = getExtension(multipartFile);
        String imageUrl = "freshman/" + UUID.randomUUID() + extension;

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        try {
            amazonS3Client.putObject(
                    new PutObjectRequest(bucket, imageUrl, multipartFile.getInputStream(), objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead)
            );
        } catch (IOException e) {
            throw ImageNotFoundException.EXCEPTION;
        }

        return amazonS3Client.getUrl(bucket, imageUrl).toString();
    }

    private String getExtension(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty() || multipartFile.getOriginalFilename() == null) {
            throw ImageNotFoundException.EXCEPTION;
        }

        String originalName = multipartFile.getOriginalFilename();
        String extension = originalName.substring(originalName.lastIndexOf("."));

        if (!(extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png") || extension.equals(".heic"))) {
            throw InvalidImageExtensionFormatException.EXCEPTION;
        }

        return extension;
    }
}
