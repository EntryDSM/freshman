package kr.hs.entrydsm.entry_freshman.domain.post.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostElement {

    private final Long id;
    private final String title;
    private final String content;
}
