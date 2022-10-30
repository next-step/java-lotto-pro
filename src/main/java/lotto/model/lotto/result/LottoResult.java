package lotto.model.lotto.result;

import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeMoney;
    private final Map<Integer, Integer> lottoCount;

    public LottoResult(Map<Integer, Integer> prizeMoney, Map<Integer, Integer> lottoCount) {
        this.prizeMoney = prizeMoney;
        this.lottoCount = lottoCount;
    }

    public int prizeMoneyForNumbersMatch(int numbersMatch) {
        return prizeMoney.get(numbersMatch);
    }

    public int lottoCountForNumbersMatch(int numbersMatch) {
        return lottoCount.get(numbersMatch);
    }
}
