package calculator.domain.calculator.factory;

import calculator.domain.calculator.model.Delimiter;
import calculator.domain.calculator.model.dto.Input;
import calculator.domain.calculator.model.policy.ParsingPolicy;

public class CalculatorFactory {

    // 커스텀 구분자가 있을 때 숫자 시작 인덱스
    private final static int CUSTOM_DELIMITER_START_INDEX = 5;

    // 기본 구분자만 있을 때 숫자 시작 인덱스
    private final static int DEFAULT_START_INDEX = 0;


    /**
     * 주어진 {@link Input}을 기반으로 적절한 {@link ParsingPolicy}를 생성한다.
     *
     * @param input 사용자가 입력한 문자열
     * @return 구분자 및 시작 인덱스를 포함한 {@link ParsingPolicy}
     * @throws IllegalArgumentException 커스텀 구분자가 숫자인 경우
     */
    public static ParsingPolicy getDelimiter(Input input) {

        String raw = input.raw();

        // 커스텀 지정자를 사용하는 경우 케이스 분리
        if(raw.startsWith("//") && raw.indexOf("\\n") == 3){ // 문자열 안에서 \n을 표현하고 싶은 경우 앞에 \ 추가하기

            // 숫자는 구분자로 사용할 수 없음
            if (Character.isDigit(raw.charAt(2))) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }

            // 기본 구분자(, :)에 커스텀 구분자 추가
            Delimiter delimiter = Delimiter.defaultSeparator();
            delimiter.addSeparator(raw.charAt(2));

            return new ParsingPolicy(delimiter, CUSTOM_DELIMITER_START_INDEX);
        }else{
            // 커스텀 구분자가 없을 경우 기본 구분자 반환
            return new ParsingPolicy(Delimiter.defaultSeparator(), DEFAULT_START_INDEX);
        }

    }
}
