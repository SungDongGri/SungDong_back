package SungDongGri.SungDong_back.exception;

import lombok.Getter;

@Getter
public class CustomInternalServerErrorException extends CustomException {
    public CustomInternalServerErrorException(ErrorCode errorCode) {
        super(errorCode);
    }
}
