package kr.hs.entrydsm.freshman.domain.post.service;

import kr.hs.entrydsm.freshman.domain.post.domain.Post;
import kr.hs.entrydsm.freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.freshman.domain.post.web.dto.request.CreatePostRequest;
import kr.hs.entrydsm.freshman.domain.user.domain.User;
import kr.hs.entrydsm.freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePostService {

    private final PostRepository postRepository;

    private final CurrentUserFacade currentUserFacade;

    public void execute(CreatePostRequest request) {
        User currentUser = currentUserFacade.getCurrentUser();

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(currentUser)
                .build();
        postRepository.save(post);
    }
}
