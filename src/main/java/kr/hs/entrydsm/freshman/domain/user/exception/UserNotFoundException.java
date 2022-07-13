package kr.hs.entrydsm.freshman.domain.user.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
