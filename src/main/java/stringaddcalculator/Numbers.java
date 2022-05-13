package stringaddcalculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers = new ArrayList<>();

    Numbers(String stringNumbers) {
        if (stringNumbers == null || stringNumbers.isEmpty()) {
            numbers.add(0);
            return;
        }
        split(stringNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void split(String stringNumbers) {
        String[] split = new SplitString(stringNumbers).getSplitString();
        for (String numberString : split) {
            numbers.add(Integer.parseInt(numberString));
        }
    }
}
