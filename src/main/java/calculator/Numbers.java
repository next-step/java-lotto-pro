package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String[] inputs) {
        this.numbers = convertToNumbers(inputs);
        checkNumbersRange();
    }

    private List<Integer> convertToNumbers(String[] inputs) {
        try {
            return Arrays.stream(inputs).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다!");
        }
    }

    private void checkNumbersRange() {
        boolean hasNegative = this.numbers.stream().anyMatch(number -> number < 0);
        if (hasNegative)
            throw new IllegalArgumentException ("[ERROR] 0 이상의 숫자를 입력해 주세요!");
    }
}
