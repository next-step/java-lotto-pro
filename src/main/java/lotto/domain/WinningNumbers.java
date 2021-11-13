package lotto.domain;

import lotto.consts.LottoNumberConst;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validationCheck(numbers);
        this.numbers = numbers;
    }

    private void validationCheck(List<Integer> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException();
        numbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != LottoNumberConst.LOTTO_NUMBER_SIZE)
            throw new IllegalArgumentException();
        for (Integer number : numbers)
            validationCheck(number);
    }

    private void validationCheck(Integer number) {
        if (number == null || number < LottoNumberConst.START_NUMBER || number > LottoNumberConst.END_NUMBER)
            throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
