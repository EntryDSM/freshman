package kr.hs.entrydsm.entry_freshman.domain.user.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MyPageResponse {

    private final String name;
    private final List<MyPageElement> myFeedList;
}
