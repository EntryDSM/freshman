package kr.hs.entrydsm.entry_freshman.domain.post.exception;

import kr.hs.entrydsm.entry_freshman.global.error.CustomException;
import kr.hs.entrydsm.entry_freshman.global.error.ErrorCode;

public class NoPermissionToDeletePostException extends CustomException {

    public static final CustomException EXCEPTION =
            new NoPermissionToDeletePostException();

    private NoPermissionToDeletePostException() {
        super(ErrorCode.NO_PERMISSION_TO_DELETE_POST);
    }
}
