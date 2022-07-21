package kr.hs.entrydsm.freshman.domain.post.service;

import kr.hs.entrydsm.freshman.domain.post.domain.Post;
import kr.hs.entrydsm.freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.freshman.domain.post.exception.PostNotFoundException;
import kr.hs.entrydsm.freshman.domain.post.web.dto.response.PostDetailsResponse;
import kr.hs.entrydsm.freshman.domain.user.domain.User;
import kr.hs.entrydsm.freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostDetailsService {

    private final static String ANONYMOUS_USER = "anonymousUser";
    private final CurrentUserFacade currentUserFacade;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostDetailsResponse execute(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (ANONYMOUS_USER.equals(currentUserFacade.getCurrentUserAccountId())) {
            return buildPostDetails(post, User.builder().build());
        } else {
            User user = currentUserFacade.getCurrentUser();
            return buildPostDetails(post, user);
        }
    }

    private PostDetailsResponse buildPostDetails(Post post, User user) {
        return PostDetailsResponse.builder()
                .name(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .isMine(post.getUser().equals(user))
                .build();
    }
}
