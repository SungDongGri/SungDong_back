package SungDongGri.SungDong_back.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * 성공 코드
     */
    OK(200, "요청이 정상적으로 수행되었습니다."),

    /**
     * 400 BAD REQUEST
     */
    BAD_REQUEST(400,"잘못된 요청입니다."),
    INVALID_PARAMETER(40001, "요청 파라미터 오류"),



    /**
     * 401
     */
    EXPIRED_TOKEN(40101, "토큰 유효 시간이 만료되었습니다"),
    INVALID_TOKEN(40102, "유효하지 않은 토큰입니다."),
    LOGIN_REQUIRED(40103, "토큰이 존재하지 않습니다. 로그인 이후 요청해주세요"),
    REFRESH_TOKEN_NOT_EXIST(40104, "리프레쉬 토큰이 존재하지 않습니다"),

    /**
     * 401
     */
    FORBIDDEN(403, "권한이 없습니다."),
    /**
     * * 403
     */


    /**
     * 404 NOT FOUND
     */
    NOT_FOUND(404, "요청한 자원을 찾을 수 없습니다."),
    NOT_FOUND_MEMBER(40401, "존재하지 않는 사용자 정보입니다"),



    /**
     * 500 서버에러
     */
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다."),
    OPEN_API_ERROR(50001, "오픈 API 호출에 오류가 있습니다.");

    private final int code;
    private final String message;
}
