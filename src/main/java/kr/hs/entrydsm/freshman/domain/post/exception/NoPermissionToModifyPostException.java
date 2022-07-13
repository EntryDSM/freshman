package kr.hs.entrydsm.freshman.domain.post.exception;

import kr.hs.entrydsm.freshman.global.error.CustomException;
import kr.hs.entrydsm.freshman.global.error.ErrorCode;

public class NoPermissionToModifyPostException extends CustomException {

    public static final NoPermissionToModifyPostException EXCEPTION = new NoPermissionToModifyPostException();

    private NoPermissionToModifyPostException() {
        super(ErrorCode.NO_PERMISSION_TO_MODIFY_POST);
    }
}
