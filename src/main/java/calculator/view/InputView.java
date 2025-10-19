package calculator.view;

import calculator.domain.calculator.model.dto.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Input inputView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String raw = Console.readLine();
        return new Input(raw);
    }
}
