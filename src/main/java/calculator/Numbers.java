package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private List<Number> numbers = new ArrayList<>();

    protected Numbers() {
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

    public void add(Number number) {
        this.numbers.add(number);
    }
}
