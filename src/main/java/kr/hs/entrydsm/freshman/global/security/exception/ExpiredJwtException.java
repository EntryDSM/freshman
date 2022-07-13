package kr.hs.entrydsm.freshman.global.security.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
