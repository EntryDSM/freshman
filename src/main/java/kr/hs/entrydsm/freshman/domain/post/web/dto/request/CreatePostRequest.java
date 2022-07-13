package kr.hs.entrydsm.freshman.domain.post.web.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreatePostRequest {

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String content;
}
