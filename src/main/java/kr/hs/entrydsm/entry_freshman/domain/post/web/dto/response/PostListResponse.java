package kr.hs.entrydsm.entry_freshman.domain.post.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private final List<PostElement> postList;
}
