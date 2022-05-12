package camp.nextstep.edu.level1.lotto.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult(List<LottoNumbers> purchaseLotto, LottoNumbers winnerLottoNumbers) {
        purchaseLotto.forEach(lotto -> {
            LottoRank rank = LottoRank.checkLottoRank(lotto, winnerLottoNumbers);
            result.putIfAbsent(rank, 0);
            result.replace(rank, result.get(rank) + 1);
        });
    }

    public Money winningAmount() {
        Money amount = new Money(0);

        for (Map.Entry<LottoRank, Integer> lottoRankIntegerEntry : result.entrySet()) {
            Money rankMoney = lottoRankIntegerEntry.getKey().rankPrice();
            Integer count = lottoRankIntegerEntry.getValue();
            Money rankTotalAmount = rankMoney.mul(count);

            amount = amount.add(rankTotalAmount);
        }

        return amount;
    }
}
