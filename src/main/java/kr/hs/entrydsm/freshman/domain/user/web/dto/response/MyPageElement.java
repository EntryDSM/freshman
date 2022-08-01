package kr.hs.entrydsm.freshman.domain.user.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageElement {

    private final Long id;
    private final String title;
    private final String content;
}
