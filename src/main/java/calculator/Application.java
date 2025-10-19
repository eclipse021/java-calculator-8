package calculator;

import calculator.domain.calculator.model.calculator.CustomCalculator;
import calculator.domain.calculator.model.dto.Input;
import calculator.domain.calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {
    public static void main(String[] args) {

        Input input = InputView.inputView();
        int result = new CalculatorService().calculate(input, new CustomCalculator());
        OutputView.outputView(result);

    }
}