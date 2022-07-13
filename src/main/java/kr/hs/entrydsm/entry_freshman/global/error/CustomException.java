package kr.hs.entrydsm.entry_freshman.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class CustomException extends RuntimeException {

    private final ErrorCode errorCode;
}
