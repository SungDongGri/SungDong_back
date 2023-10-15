package SungDongGri.SungDong_back.exception;

public class CustomForbiddenException extends CustomException {
    public CustomForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
