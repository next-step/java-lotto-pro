package calculator;

public class StringCalculator {

    private PositiveOperandBag operandBag;
    private static final int NOT_CALCULATED = 0;

    public int calculate(String input) {
        if (isNotCalculated(input)) {
            return NOT_CALCULATED;
        }
        operandBag = new PositiveOperandBag(Separator.separate(input));
        return operandBag.sum();
    }

    private boolean isNotCalculated(String input) {
        return input == null || input.trim().equals("");
    }
}
