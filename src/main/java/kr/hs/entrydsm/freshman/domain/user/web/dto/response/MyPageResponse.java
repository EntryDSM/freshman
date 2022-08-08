package kr.hs.entrydsm.freshman.domain.user.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MyPageResponse {

    private final String name;
    private final String introduce;
    private final String profileUrl;
    private final List<MyPageElement> myFeedList;
}
