package lotto.domain;

import lotto.constants.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static lotto.domain.PayAmount.LOTTO_PRICE;

public class LottoResult {

    private final HashMap<Rank, Integer> lottoResult;

    public LottoResult(HashMap<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<Rank, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public BigDecimal profit(Rank rank) {
        return BigDecimal.valueOf(rank.getWinningMoney())
                .multiply(BigDecimal.valueOf(lottoResult.getOrDefault(rank, 0)));
    }

    public BigDecimal calculateProfitRatio(int lottoAmount) {
        BigDecimal profit = BigDecimal.valueOf(0);
        for (Rank rank : lottoResult.keySet()) {
            profit = profit.add(profit(rank));
        }
        return profit.divide(BigDecimal.valueOf(lottoAmount * LOTTO_PRICE), 2, RoundingMode.DOWN);
    }
}
