package lotto.model.lotto.result;

import lotto.model.money.to.buy.MoneyToBuy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public double profitRatio(MoneyToBuy moneyToBuy) {
        final double sumOfPrizes = (double) sumOfPrizes();
        return moneyToBuy.profitRatio(sumOfPrizes);
    }

    public int sumOfPrizes() {
        final Set<Integer> keySet = prizeMoney.keySet();
        final List<Integer> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);
        int sum = 0;
        for (int numbersMatch : numbersMatchCandidates) {
            final int prizeMultipliedByCount = prizeMoney.get(numbersMatch) * numbersMatchCount.get(numbersMatch);
            sum += prizeMultipliedByCount;
        }
        return sum;
    }
}
