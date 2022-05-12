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

    public Money getWinningAmount() {
        Money amount = new Money(0);

        result.forEach((key, value) -> {
            long rankTotalAmount = key.getPrice().getValue() * value;
            amount.add(rankTotalAmount);
        });

        return amount;
    }
}
