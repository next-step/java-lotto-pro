package lottoauto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputNumberValidator {
    private static final String DEFAULT_REGEX = ", ";
    private List<Integer> numbers = new ArrayList<>();

    public InputNumberValidator(String input) {
        String[] splitResult = input.split(DEFAULT_REGEX);
        Integer[] arrNumbers = new Integer[splitResult.length];
        try {
            Arrays.setAll(arrNumbers, i -> Integer.parseInt(splitResult[i]));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("구분자는 ', '로 입력해야합니다.");
        }

        Collections.addAll(numbers, arrNumbers);
    }

    @Override
    public String toString() {
        return "InputNumberValidator{" +
                "numbers=" + numbers +
                '}';
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
