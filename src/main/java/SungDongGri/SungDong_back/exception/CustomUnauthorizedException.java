package SungDongGri.SungDong_back.exception;

public class CustomUnauthorizedException extends CustomException {
    public CustomUnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
