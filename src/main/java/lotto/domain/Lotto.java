package lotto.domain;

import lotto.consts.ContainConst;
import lotto.consts.LottoNumberConst;
import lotto.consts.WinningEnum;
import lotto.exception.WrongLottoSizeException;

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
        if (numbers == null) {
            throw new NullPointerException();
        }

        numbers = getDistinctNumbers(numbers);

        if (numbers.size() != LottoNumberConst.LOTTO_NUMBER_SIZE) {
            throw new WrongLottoSizeException();
        }

        for (Integer number : numbers) {
            validationCheck(number);
        }
    }

    private List<Integer> getDistinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }

    private void validationCheck(Integer number) {
        if (number == null || number < LottoNumberConst.START_NUMBER || number > LottoNumberConst.END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinningEnum getWinningResult(Lotto winningLotto, BonusNumber bonusNumber) {
        int matched = getMatched(winningLotto.getNumbers());
        int bonusNumberMatched = matched == WinningEnum.SECOND.getMatched() ? isContain(bonusNumber.getBonusNumber(), numbers) : 0;
        return WinningEnum.findByMatched(matched, bonusNumberMatched);
    }

    private int getMatched(List<Integer> winningNumbers) {
        int matched = 0;
        for (int number : numbers) {
            matched += isContain(number, winningNumbers);
        }
        return matched;
    }

    private int isContain(int number, List<Integer> numbers) {
        if (numbers.contains(number))
            return ContainConst.TRUE;
        return ContainConst.FALSE;
    }
}
