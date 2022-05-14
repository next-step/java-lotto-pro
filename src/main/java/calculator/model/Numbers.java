package calculator.model;

import calculator.exception.IllegalArgument;
import java.util.Arrays;

public class Numbers {
    int[] numbers;

    Numbers(String[] numbers) {
        try{
            this.numbers = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        } catch(NumberFormatException e) {
            throw IllegalArgument.NEGATIVE_OR_NOT_NUMBER;
        }


        if (isContainNegativeNumber()) {
            throw IllegalArgument.NEGATIVE_OR_NOT_NUMBER;
        }
    }

    private boolean isContainNegativeNumber() {
        return Arrays.stream(numbers).anyMatch(n -> n < 0);
    }

    public int sumNumbers() {
        return Arrays.stream(numbers).sum();
    }
}
