package camp.nextstep.edu.common;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> numbers = new ArrayList<>();

    public PositiveNumbers(List<Long> numberList, Long ...numbers) {
        for (Long number: numberList) {
            this.numbers.add(new PositiveNumber(number));
        }
        for (Long number: numbers) {
            this.numbers.add(new PositiveNumber(number));
        }
    }

    public PositiveNumbers(List<String> stringNumbers, String ...numbers) {
        for (String number: stringNumbers) {
            this.numbers.add(new PositiveNumber(number));
        }
        for (String number: numbers) {
            this.numbers.add(new PositiveNumber(number));
        }
    }

    public long sum() {
        return this.numbers.stream().mapToLong(PositiveNumber::getValue).sum();
    }
}
