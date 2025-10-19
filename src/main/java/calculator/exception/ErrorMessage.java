package calculator.exception;

public class ErrorMessage {

    private ErrorMessage() {
        // 인스턴스화 방지
    }

    /** 커스텀 구분자가 숫자인 경우 */
    public static final String INVALID_DELIMITER = "숫자는 구분자로 사용할 수 없습니다.";

    /** 음수 입력이 포함된 경우 */
    public static final String NEGATIVE_NUMBER_NOT_ALLOWED = "음수는 허용되지 않습니다.";

    /** 숫자 형식 오류 또는 int 범위를 초과한 경우 */
    public static final String INVALID_NUMBER_FORMAT = "유효하지 않은 숫자입니다 (형식 오류 또는 int 범위 초과)";

}
