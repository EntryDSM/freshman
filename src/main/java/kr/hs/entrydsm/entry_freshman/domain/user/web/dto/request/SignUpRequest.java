package kr.hs.entrydsm.entry_freshman.domain.user.web.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;

    @NotBlank
    private String name;
}
