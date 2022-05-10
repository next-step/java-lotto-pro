package camp.nextstep.edu.view;

import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;

public class OutputView {
    private OutputView() {}

    public static void enterCalculateValue(StringCalculator calculator) {
        System.out.println("계산 결과는 " + calculator.sum() + " 입니다.");
    }
}
