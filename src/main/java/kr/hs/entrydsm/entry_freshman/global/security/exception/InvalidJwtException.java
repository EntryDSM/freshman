package kr.hs.entrydsm.entry_freshman.global.security.exception;

import kr.hs.entrydsm.entry_freshman.global.error.CustomException;
import kr.hs.entrydsm.entry_freshman.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
