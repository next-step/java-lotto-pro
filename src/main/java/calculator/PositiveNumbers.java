package calculator;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers from(String[] numbers) {
        List<PositiveNumber> positiveNumbers = new ArrayList<>();
        for (String number : numbers) {
            positiveNumbers.add(PositiveNumber.parseNotNegativeNumber(number));
        }
        return new PositiveNumbers(positiveNumbers);
    }

    public int getSum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumbers) {
            sum += positiveNumber.getPositiveNumber();
        }
        return sum;
    }
}
