package kr.hs.entrydsm.entry_freshman.domain.user.service;

import kr.hs.entrydsm.entry_freshman.domain.user.domain.User;
import kr.hs.entrydsm.entry_freshman.domain.user.domain.UserRepository;
import kr.hs.entrydsm.entry_freshman.domain.user.exception.PasswordMisMatchException;
import kr.hs.entrydsm.entry_freshman.domain.user.exception.UserNotFoundException;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.request.SignInRequest;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response.TokenResponse;
import kr.hs.entrydsm.entry_freshman.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateToken(user.getAccountId());
        return new TokenResponse(accessToken);
    }
}
