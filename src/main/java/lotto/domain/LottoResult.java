package lotto.domain;

import lotto.constants.Rank;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
}
