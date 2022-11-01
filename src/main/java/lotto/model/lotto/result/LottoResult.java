package lotto.model.lotto.result;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeMoney;
    private final Map<Integer, Integer> numbersMatchCount;

    public LottoResult(Map<Integer, Integer> prizeMoney, Map<Integer, Integer> numbersMatchCount) {
        this.prizeMoney = prizeMoney;
        this.numbersMatchCount = numbersMatchCount;
    }

    public int prizeMoneyForNumbersMatch(int numbersMatch) {
        return prizeMoney.get(numbersMatch);
    }

    public int lottoCountForNumbersMatch(int numbersMatch) {
        return numbersMatchCount.get(numbersMatch);
    }
}
