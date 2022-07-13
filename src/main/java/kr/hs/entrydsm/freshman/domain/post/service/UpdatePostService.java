package kr.hs.entrydsm.freshman.domain.post.service;

import kr.hs.entrydsm.freshman.domain.post.domain.Post;
import kr.hs.entrydsm.freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.freshman.domain.post.exception.NoPermissionToModifyPostException;
import kr.hs.entrydsm.freshman.domain.post.exception.PostNotFoundException;
import kr.hs.entrydsm.freshman.domain.post.web.dto.request.UpdatePostRequest;
import kr.hs.entrydsm.freshman.domain.user.domain.User;
import kr.hs.entrydsm.freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdatePostService {

    private final CurrentUserFacade currentUserFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long postId, UpdatePostRequest request) {
        User currentUser = currentUserFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (!post.getUser().equals(currentUser)) {
            throw NoPermissionToModifyPostException.EXCEPTION;
        }

        post.updateTitleAndContent(request);
    }
}
