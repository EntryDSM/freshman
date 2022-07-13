package kr.hs.entrydsm.entry_freshman.global.facade;

import kr.hs.entrydsm.entry_freshman.domain.user.domain.User;
import kr.hs.entrydsm.entry_freshman.domain.user.domain.UserRepository;
import kr.hs.entrydsm.entry_freshman.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CurrentUserFacade {

    private final UserRepository userRepository;

    public String getCurrentUserAccountId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getCurrentUser() {
        return userRepository.findByAccountId(getCurrentUserAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
