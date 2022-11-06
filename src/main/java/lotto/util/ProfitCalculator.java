package lotto.util;

import lotto.constants.Rank;
import lotto.domain.LottoResult;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.domain.PayAmount.LOTTO_PRICE;

public class ProfitCalculator {

    public static BigDecimal calculateProfitRatio(LottoResult lottoResult, int lottoAmount) {
        BigDecimal profit = BigDecimal.valueOf(0);
        for (Rank rank : lottoResult.getLottoResult().keySet()) {
            profit = profit.add(lottoResult.profit(rank));
        }
        return profit.divide(BigDecimal.valueOf(lottoAmount * LOTTO_PRICE), 2, RoundingMode.DOWN);
    }
}
