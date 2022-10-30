package calculator.domain;

import calculator.domain.target.Target;

public class StringAddCalculator {

    private static final int DEFAULT_RESULT = 0;
    private Target target;

    public StringAddCalculator(Target target) {
        this.target = target;
    }

    public int calculate() {
        int result = DEFAULT_RESULT;
        for (int target : target.target()) {
            result += target;
        }
        return result;
    }
}
