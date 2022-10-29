package study.lotto.domain;

import study.util.NumberUtil;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbersFromStore) {
        this.numbers = numbersFromStore;
    }

    public LottoStatus drawLots(WinningNumbers winningNumbers) {
        int result = matchNumbers(winningNumbers);
        return LottoStatus.getLottoStatus(result);
    }

    private int matchNumbers(WinningNumbers winningNumbers) {
        int result = NumberUtil.INIT_ZERO;
        for(Integer num : numbers) {
            result += winningNumbers.matchNumber(num);
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
