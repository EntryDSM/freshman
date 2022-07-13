package kr.hs.entrydsm.entry_freshman.domain.post.exception;

import kr.hs.entrydsm.entry_freshman.global.error.CustomException;
import kr.hs.entrydsm.entry_freshman.global.error.ErrorCode;

public class NoPermissionToModifyPostException extends CustomException {

    public static final NoPermissionToModifyPostException EXCEPTION = new NoPermissionToModifyPostException();

    private NoPermissionToModifyPostException() {
        super(ErrorCode.NO_PERMISSION_TO_MODIFY_POST);
    }
}
