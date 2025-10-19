package calculator.domain.calculator.model.calculator;

import calculator.domain.calculator.factory.CalculatorFactory;
import calculator.domain.calculator.model.Delimiter;
import calculator.domain.calculator.model.dto.Input;
import calculator.domain.calculator.model.policy.ParsingPolicy;
import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.utils.ParserNumber;

import java.util.List;

public class CustomCalculator extends Calculator {

    @Override
    public int calculate(Input input) {

        String raw = input.raw();

        // 구분자 사이 저장할 숫자
        String stored = "";
        // 총합
        int sum = 0;

        ParsingPolicy parsingPolicy = CalculatorFactory.getDelimiter(input);
        final int startIndex = parsingPolicy.startIndex();
        final Delimiter delimiter = parsingPolicy.delimiter();


        for(int i = startIndex; i < raw.length(); i++) {

            if(delimiter.getSeparators().contains(raw.charAt(i))) {
                int value = ParserNumber.parseNumber(stored);
                sum += value;

                stored = "";
            }else{

                stored += raw.charAt(i);
            }
        }

        // 마지막에 stored에 값이 있을 경우 추가로 총합에 덧셈
        if (!stored.isEmpty()) {
            sum += ParserNumber.parseNumber(stored);
        }

        return sum;
    }
}
