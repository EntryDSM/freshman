package kr.hs.entrydsm.freshman.domain.image.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class InvalidImageExtensionFormatException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidImageExtensionFormatException();

    private InvalidImageExtensionFormatException() {
        super(ErrorCode.INVALID_EXTENSION_FORMAT);
    }
}
