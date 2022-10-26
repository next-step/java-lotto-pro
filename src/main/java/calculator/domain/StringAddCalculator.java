package calculator.domain;

import calculator.domain.target.Target;

public class StringAddCalculator {

    private Target target;

    public StringAddCalculator(Target target) {
        this.target = target;
    }

    public int calculate() {
        int result = 0;
        for (int target : target.target()) {
            result += target;
        }
        return result;
    }
}
