package camp.nextstep.edu.common;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> numbers = new ArrayList<>();

    public PositiveNumbers(List<Integer> numberList, Integer ...numbers) {
        for (Integer number: numberList) {
            this.numbers.add(new PositiveNumber(number));
        }
        for (Integer number: numbers) {
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

    public int sum() {
        return this.numbers.stream().mapToInt(value -> value.value).sum();
    }
}
