package SungDongGri.SungDong_back.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    /**
     * 성공 코드
     */
    OK(0,HttpStatus.OK, "요청이 정상적으로 수행되었습니다.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}