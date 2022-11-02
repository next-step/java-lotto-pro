package lotto.util;

import lotto.constants.Rank;
import lotto.domain.LottoResult;

import static lotto.domain.PayAmount.LOTTO_PRICE;

public class ProfitCalculator {

    public static double calculateProfitRatio(LottoResult lottoResult, int lottoAmount) {
        double profit = 0;
        for (Rank rank : lottoResult.getLottoResult().keySet()) {
            profit += lottoResult.profit(rank);
        }
        return Math.floor(profit / (lottoAmount * LOTTO_PRICE) * 100) / 100;
    }
}
