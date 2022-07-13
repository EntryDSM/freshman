package kr.hs.entrydsm.entry_freshman.domain.user.web;

import kr.hs.entrydsm.entry_freshman.domain.user.service.MyPageService;
import kr.hs.entrydsm.entry_freshman.domain.user.service.SignInService;
import kr.hs.entrydsm.entry_freshman.domain.user.service.SignUpService;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.request.SignInRequest;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.request.SignUpRequest;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response.MyPageResponse;
import kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final SignUpService signUpService;
    private final SignInService signInService;
    private final MyPageService myPageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return signInService.execute(request);
    }

    @GetMapping("/mypage")
    public MyPageResponse myPage() {
        return myPageService.execute();
    }
}
