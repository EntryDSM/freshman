package kr.hs.entrydsm.freshman.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    INVALID_EXTENSION_FORMAT(401, "Invalid Extension Format"),

    PASSWORD_MISMATCH(401, "Password MisMatch"),
    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    NO_PERMISSION_TO_MODIFY_POST(401, "No Permission To Modify Post"),
    NO_PERMISSION_TO_DELETE_POST(401, "No Permission To Delete Post"),

    USER_NOT_FOUND(404, "User Not Found"),
    POST_NOT_FOUND(404, "Post Not Found"),
    IMAGE_NOT_FOUND(404, "Image Not Found"),

    USER_EXISTS(409, "User Exists"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;

}
