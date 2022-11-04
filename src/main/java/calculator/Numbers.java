package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Number> numbers = new ArrayList<>();

    private Numbers() {
    }

    public Numbers(String[] splitText) {
        for (String text : splitText) {
            this.numbers.add(new Number(text));
        }
    }

    public int sum() {
        int sum = 0;
        for (Number number : this.numbers) {
            sum += number.getNumber();
        }
        return sum;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
