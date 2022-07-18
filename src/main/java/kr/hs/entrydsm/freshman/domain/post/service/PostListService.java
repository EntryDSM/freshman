package kr.hs.entrydsm.freshman.domain.post.service;

import kr.hs.entrydsm.freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostElement;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostListService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostListResponse execute() {
        List<PostElement> postList = postRepository.findAll()
                .stream()
                .map(post -> new PostElement(post.getId(), post.getTitle()))
                .collect(Collectors.toList());

        return new PostListResponse(postList);
    }
}
