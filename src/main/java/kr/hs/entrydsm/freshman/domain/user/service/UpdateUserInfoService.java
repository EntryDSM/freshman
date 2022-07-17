package kr.hs.entrydsm.freshman.domain.user.service;

import kr.hs.entrydsm.freshman.domain.user.domain.User;
import kr.hs.entrydsm.freshman.domain.user.web.dto.request.UpdateUserInfoRequest;
import kr.hs.entrydsm.freshman.global.facade.CurrentUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {

    private final CurrentUserFacade currentUserFacade;

    @Transactional()
    public void execute(UpdateUserInfoRequest request) {
        User user = currentUserFacade.getCurrentUser();

        user.update(request.getName(), request.getIntroduce(), request.getProfileImageUrl());
    }
}
