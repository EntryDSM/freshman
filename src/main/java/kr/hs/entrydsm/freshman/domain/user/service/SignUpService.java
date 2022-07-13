package kr.hs.entrydsm.freshman.domain.user.service;

import kr.hs.entrydsm.freshman.domain.user.domain.User;
import kr.hs.entrydsm.freshman.domain.user.domain.UserRepository;
import kr.hs.entrydsm.freshman.domain.user.exception.UserExistsException;
import kr.hs.entrydsm.freshman.domain.user.web.dto.request.SignUpRequest;
import kr.hs.entrydsm.freshman.domain.user.web.dto.response.TokenResponse;
import kr.hs.entrydsm.freshman.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignUpRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .build();
        userRepository.save(user);

        String accessToken = jwtTokenProvider.generateToken(user.getAccountId());
        return new TokenResponse(accessToken);
    }
}
