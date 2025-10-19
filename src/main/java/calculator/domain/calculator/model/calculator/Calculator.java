package calculator.domain.calculator.model.calculator;

import calculator.domain.calculator.model.Delimiter;
import calculator.domain.calculator.model.dto.Input;

import java.util.List;

public abstract class Calculator {

    /**
     * 주어진 입력 문자열을 계산하여 결과를 반환한다.
     *
     * @param input 사용자의 원본 입력 (빈 문자열일 수 있음)
     * @return 모든 숫자의 합
     * @throws IllegalArgumentException 음수가 포함되거나 유효하지 않은 입력일 때
     */
    public abstract int calculate(Input input);

}
