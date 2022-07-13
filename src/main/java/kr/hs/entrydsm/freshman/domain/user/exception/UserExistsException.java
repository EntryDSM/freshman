package kr.hs.entrydsm.freshman.domain.user.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class UserExistsException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.USER_EXISTS);
    }
}
