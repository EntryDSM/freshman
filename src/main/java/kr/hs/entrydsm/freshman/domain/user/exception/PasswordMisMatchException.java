package kr.hs.entrydsm.freshman.domain.user.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final PasswordMisMatchException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
