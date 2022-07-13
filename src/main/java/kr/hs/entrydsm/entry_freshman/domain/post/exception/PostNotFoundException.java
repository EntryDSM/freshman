package kr.hs.entrydsm.entry_freshman.domain.post.exception;

import kr.hs.entrydsm.entry_freshman.global.error.CustomException;
import kr.hs.entrydsm.entry_freshman.global.error.ErrorCode;

public class PostNotFoundException extends CustomException {

    public static final PostNotFoundException EXCEPTION =
            new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
