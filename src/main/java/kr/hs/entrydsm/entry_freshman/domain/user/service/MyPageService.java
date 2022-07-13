package kr.hs.entrydsm.entry_freshman.domain.user.service;

import kr.hs.entrydsm.entry_freshman.domain.post.domain.PostRepository;
import kr.hs.entrydsm.entry_freshman.domain.user.domain.User;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response.MyPageElement;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response.MyPageResponse;
import kr.hs.entrydsm.entry_freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final CurrentUserFacade currentUserFacade;
    private final PostRepository postRepository;

    public MyPageResponse execute() {
        User user = currentUserFacade.getCurrentUser();

        List<MyPageElement> postList = postRepository.findAllByUserId(user.getId())
                .stream()
                .map(post -> new MyPageElement(post.getTitle(), post.getContent()))
                .collect(Collectors.toList());

        return new MyPageResponse(user.getName(), postList);
    }
}
