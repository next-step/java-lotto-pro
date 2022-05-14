package stringAddCalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers(String[] numbers) throws IllegalAccessException {
        List<Number> list = new ArrayList<>();
        for (String s: numbers) {
            list.add(new Number(s));
        }
        this.numbers = list;
    }

    public int sumNumbers() {
        int result =  0;
        for (Number n : this.numbers) {
            result += n.getNumber();
        }
        return result;
    }
}
