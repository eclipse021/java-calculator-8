package calculator.domain.calculator.service;

import calculator.domain.calculator.model.calculator.Calculator;
import calculator.domain.calculator.model.dto.Input;

public class CalculatorService {

    /**
     * 주어진 입력을 기반으로 계산을 수행한다.
     * 입력이 null 이거나 빈 문자열("")인 경우 0을 반환하고,
     * 그렇지 않으면 {@link Calculator}에 계산을 위임한다.
     *
     * @param input 사용자의 원본 입력
     * @param calculator 실제 계산을 수행할 {@link Calculator} 구현체
     * @return 계산 결과 값
     */
    public int calculate(Input input, Calculator calculator) {

        if(input == null || input.raw().equals("")) {
            return 0;
        }
        return calculator.calculate(input);
    }

}
