package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Number> numbers = new ArrayList<>();

    protected Numbers() {
    }

    public Numbers(String[] splitText) {
        for (String text : splitText) {
            this.numbers.add(new Number(text));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int sum() {
        int sum = 0;
        for (Number number : this.numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}
