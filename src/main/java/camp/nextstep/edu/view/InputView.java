package camp.nextstep.edu.view;

import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static StringCalculator enterCalculateValue() {
        System.out.println("양수를 구분자와 함께 입력해 주세요. (기본 구분자는 :, 이며 // \\n 로 시작되면 해당 문자 사이의 값으로 구분하여 계산합니다.)");

        return new StringCalculator(scanner.nextLine());
    }
}
