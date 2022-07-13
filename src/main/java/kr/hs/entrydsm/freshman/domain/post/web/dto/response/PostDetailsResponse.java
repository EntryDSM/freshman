package kr.hs.entrydsm.freshman.domain.post.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDetailsResponse {

    private final String title;
    private final String content;
}
