package study.lotto.domain;

import study.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbersFromStore) {
        numbers.addAll(numbersFromStore);
    }

    public LottoStatus drawLots(List<Integer> winningNumbers) {
        int result = matchNumbers(winningNumbers);
        return LottoStatus.getLottoStatus(result);
    }

    private int matchNumbers(List<Integer> winningNumbers) {
        int result = NumberUtil.INIT_ZERO;
        for(Integer num : numbers) {
            result += Collections.frequency(winningNumbers, num);
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
