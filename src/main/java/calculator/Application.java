package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("결과 : " + new Calculator().calculator());

    }
}

class Calculator {

    public static int calculator() {

        // 구분자 목록 생성
        Set<Character> operators = new HashSet<>(Arrays.asList(',' , ':'));

        // 입력 받기
        String input = Console.readLine();

        // 구분자 사이 저장할 숫자
        String stored = "";

        // 총합
        int sum = 0;


        for(int i = 0; i < input.length(); i++) {

            if(operators.contains(input.charAt(i))) {
                int value = parseNumber(stored);
                sum += value;

                stored = "";
            }else{

                stored += input.charAt(i);
            }
        }

        // 마지막에 stored에 값이 있을 경우 추가로 총합에 덧셈
        if (!stored.isEmpty()) {
            sum += parseNumber(stored);
        }

        return sum;

    }

    private static int parseNumber(String str) {
        try {
            int n = Integer.parseInt(str);
            if (n < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다");
            }
            return n;
        } catch (NumberFormatException e) {
            // 숫자가 아니거나, int 범위를 초과한 경우 예외 처리
            throw new IllegalArgumentException("유효하지 않은 숫자입니다 (형식 오류 또는 int 범위 초과)");
        }
    }

}