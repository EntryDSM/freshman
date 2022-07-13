package kr.hs.entrydsm.freshman.global.security.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
