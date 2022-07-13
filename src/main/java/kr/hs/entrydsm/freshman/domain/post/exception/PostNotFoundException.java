package kr.hs.entrydsm.freshman.domain.post.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class PostNotFoundException extends CustomException {

    public static final PostNotFoundException EXCEPTION =
            new PostNotFoundException();

    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
