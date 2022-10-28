package calculator;

public class StringCalculator {

    private static final int NOT_CALCULATED = 0;

    public static int calculate(String input) {
        if (isNotCalculated(input)) {
            return NOT_CALCULATED;
        }
        PositiveOperandBag operandBag = new PositiveOperandBag(Separator.separate(input));
        return operandBag.sum();
    }

    private static boolean isNotCalculated(String input) {
        return input == null || input.trim().equals("");
    }
}
