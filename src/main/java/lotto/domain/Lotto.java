package lotto.domain;

import lotto.consts.LottoNumberConst;
import lotto.consts.WinningEnum;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validationCheck(numbers);
        Collections.sort(numbers);
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
        int count = 0;
        for (int number : numbers)
            count += isContain(number, winningNumbers.getNumbers());
        if (count == LottoNumberConst.LOTTO_NUMBER_SIZE)
            return WinningEnum.FIRST.getRank();
        if (count == LottoNumberConst.LOTTO_NUMBER_SIZE - 1)
            return WinningEnum.THIRD.getRank();
        if (count == LottoNumberConst.LOTTO_NUMBER_SIZE - 2)
            return WinningEnum.FOURTH.getRank();
        if (count == LottoNumberConst.LOTTO_NUMBER_SIZE - 3)
            return WinningEnum.FIFTH.getRank();
        return WinningEnum.NONE.getRank();
    }

    private int isContain(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number))
            return 1;
        return 0;
    }
}
