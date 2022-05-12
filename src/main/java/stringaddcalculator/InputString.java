package stringaddcalculator;

import java.util.ArrayList;
import java.util.List;

public class InputString {
    private final String input;
    private final List<Integer> numbers = new ArrayList<>();

    InputString(String input) {
        this.input = input;
        setNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void setNumbers() {
        if (input == null || input.isEmpty()) {
            numbers.add(0);
            return;
        }
        split();
    }

    private void split() {
        String[] split = new SplitString(input).getSplitString();
        for (String numberString : split) {
            numbers.add(Integer.parseInt(numberString));
        }
    }
}
