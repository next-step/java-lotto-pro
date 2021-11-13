package lotto.domain;

import lotto.consts.LottoNumberConst;
import lotto.consts.WinningEnum;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
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

    public int getWinningResult(WinningNumbers winningNumbers) {
        return WinningEnum.NONE.getRank();
    }
}
