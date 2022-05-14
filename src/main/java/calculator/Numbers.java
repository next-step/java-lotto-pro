package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(String[] inputs) {
        this.numbers = convertToNumbers(inputs);
    }

    private List<Integer> convertToNumbers(String[] inputs) {
        try {
            return Arrays.stream(inputs).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다!");
        }
    }
}
