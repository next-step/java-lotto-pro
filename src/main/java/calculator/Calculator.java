package calculator;

import java.util.Arrays;

public class Calculator {
    private final int[] addTargets;

    public Calculator(String[] arguments) {
        this.addTargets = Convertor.convert(arguments);
    }

    public int sum() {
        return Arrays.stream(this.addTargets).sum();
    }
}
