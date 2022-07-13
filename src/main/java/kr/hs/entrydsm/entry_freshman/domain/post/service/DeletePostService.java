package kr.hs.entrydsm.entry_freshman.domain.post.service;

import kr.hs.entrydsm.entry_freshman.domain.post.domain.Post;
import kr.hs.entrydsm.entry_freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.entry_freshman.domain.post.exception.NoPermissionToDeletePostException;
import kr.hs.entrydsm.entry_freshman.domain.post.exception.PostNotFoundException;
import kr.hs.entrydsm.entry_freshman.domain.user.domain.User;
import kr.hs.entrydsm.entry_freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DeletePostService {

    private final CurrentUserFacade currentUserFacade;
    private final PostRepository postRepository;

    @Transactional
    public void execute(Long postId) {
        User user = currentUserFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if (!post.getUser().equals(user)) {
            throw NoPermissionToDeletePostException.EXCEPTION;
        }

        postRepository.delete(post);
    }
}
