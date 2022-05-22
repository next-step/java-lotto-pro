package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(LottoNumbersInput numbersText) {
        numbers = convertText(numbersText);
    }

    public boolean contains(LottoNo number) {
        return this.numbers.contains(number.value());
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    private List<Integer> convertText(LottoNumbersInput numbersText) {
        return Arrays.stream(numbersText.toArray())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
