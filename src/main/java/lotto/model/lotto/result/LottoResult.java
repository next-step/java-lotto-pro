package lotto.model.lotto.result;

import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.money.to.buy.MoneyToBuy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<LottoNumberMatchCount, Integer> prizeMoney;
    private final Map<LottoNumberMatchCount, Integer> numbersMatchCount;

    public LottoResult(Map<LottoNumberMatchCount, Integer> prizeMoney,
                       Map<LottoNumberMatchCount, Integer> numbersMatchCount) {
        this.prizeMoney = prizeMoney;
        this.numbersMatchCount = numbersMatchCount;
    }

    public int prizeMoneyForNumbersMatch(LottoNumberMatchCount numbersMatch) {
        return prizeMoney.get(numbersMatch);
    }

    public int lottoCountForNumbersMatch(LottoNumberMatchCount numbersMatch) {
        return numbersMatchCount.get(numbersMatch);
    }

    public double profitRatio(MoneyToBuy moneyToBuy) {
        final double sumOfPrizes = (double) sumOfPrizes();
        return moneyToBuy.profitRatio(sumOfPrizes);
    }

    protected int sumOfPrizes() {
        final Set<LottoNumberMatchCount> keySet = prizeMoney.keySet();
        final List<LottoNumberMatchCount> numbersMatchCandidates = new ArrayList<>(keySet.size());
        numbersMatchCandidates.addAll(keySet);
        int sum = 0;
        for (LottoNumberMatchCount numbersMatch : numbersMatchCandidates) {
            final int prizeMultipliedByCount = prizeMoney.get(numbersMatch) * numbersMatchCount.get(numbersMatch);
            sum += prizeMultipliedByCount;
        }
        return sum;
    }
}
