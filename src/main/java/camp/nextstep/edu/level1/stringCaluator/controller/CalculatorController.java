package camp.nextstep.edu.level1.stringCaluator.controller;

import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;
import camp.nextstep.edu.view.InputView;
import camp.nextstep.edu.view.OutputView;

public class CalculatorController {

    private CalculatorController() {}

    public static void executeStringCalculator() {
        StringCalculator calculator = InputView.enterCalculateValue();
        OutputView.showCalculateResult(calculator);
    }
}
