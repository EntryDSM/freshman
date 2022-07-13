package kr.hs.entrydsm.freshman.domain.post.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class NoPermissionToDeletePostException extends CustomException {

    public static final CustomException EXCEPTION =
            new NoPermissionToDeletePostException();

    private NoPermissionToDeletePostException() {
        super(ErrorCode.NO_PERMISSION_TO_DELETE_POST);
    }
}
