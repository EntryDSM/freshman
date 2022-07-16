package kr.hs.entrydsm.freshman.domain.user.web.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 6, max = 20)
    private String accountId;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,24}$",
            message = "password는 대문자[A-Z], 소문자[a-z], 숫자[0-9], 특수문자[!, @, #, $, %, ^, &, +, =]가 최소 1개씩 포함되어야 합니다.")
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;
}
