package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int SUM_INIT = 0;
    private List<Number> numbers = new ArrayList<>();

    private Numbers() {
    }

    public Numbers(String[] splitText) {
        for (String text : splitText) {
            this.numbers.add(new Number(text));
        }
    }

    public int sum() {
        int sum = SUM_INIT;
        for (Number number : this.numbers) {
            sum += number.getNumber();
        }
        return sum;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
