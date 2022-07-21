package kr.hs.entrydsm.freshman.domain.post.web.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDetailsResponse {

    private final String name;
    private final String title;
    private final String content;
    private final Boolean isMine;
}
