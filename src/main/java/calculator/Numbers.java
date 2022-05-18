package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private static final String ZERO = "0";
    private List<Number> numbers;

    public Numbers(String input) {
        this.numbers = new ArrayList<>();
        List<String> numbers = Splitter.splitNumbers(input);
        for (String number : numbers) {
            this.numbers.add(new Number(number));
        }
    }

    public int sum() {
        Number sum = new Number(ZERO);
        for (Number number : numbers) {
            sum.add(number);
        }
        return sum.getNumber();
    }
}
