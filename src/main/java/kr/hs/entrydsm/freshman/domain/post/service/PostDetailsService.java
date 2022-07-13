package kr.hs.entrydsm.freshman.domain.post.service;

import kr.hs.entrydsm.freshman.domain.post.domain.Post;
import kr.hs.entrydsm.freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.freshman.domain.post.exception.PostNotFoundException;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostDetailsService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostDetailsResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        return new PostDetailsResponse(post.getTitle(), post.getContent());
    }
}
