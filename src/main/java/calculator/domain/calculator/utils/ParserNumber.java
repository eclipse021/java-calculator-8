package calculator.domain.calculator.utils;

import calculator.exception.ErrorMessage;

public class ParserNumber {

    /**
     * 문자열을 정수로 변환한다.
     * 음수이거나 숫자 형식이 잘못된 경우 예외를 발생시킨다.
     *
     * @param str 변환할 문자열
     * @return 변환된 양의 정수
     * @throws IllegalArgumentException 음수이거나 유효하지 않은 숫자일 때
     */
    public static int parseNumber(String str) {
        try {
            int n = Integer.parseInt(str);

            // 음수 입력일 경우 예외 처리
            if (n < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
            }
            return n;
        } catch (NumberFormatException e) {
            // 숫자가 아니거나, int 범위를 초과한 경우 예외 처리
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
