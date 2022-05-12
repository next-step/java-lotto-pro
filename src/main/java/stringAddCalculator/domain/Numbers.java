package stringAddCalculator.domain;

import java.util.ArrayList;
import java.util.List;

import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(String[] numbers) throws IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        for (String s: numbers) {
            list.add(isDigitAndPositiveNum(s));
        }
        this.numbers = list;
    }

    public int sumNumbers() {
        int result =  0;
        for (int i : this.numbers) {
            result += i;
        }
        return result;
    }

    public static int isDigitAndPositiveNum(String input) throws IllegalAccessException {
        if (input.length() > 1) {
            throw new IllegalAccessException(INPUT_ERROR);
        }

        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalAccessException(INPUT_ERROR);
        }
        return Integer.parseInt(input);
    }
}
