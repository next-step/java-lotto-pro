package lotto.util;

import lotto.constants.Rank;
import lotto.domain.LottoResult;

import static lotto.domain.PayAmount.LOTTO_PRICE;

public class ProfitCalculator {

    public static double calculateProfit(LottoResult lottoResult, int lottoAmount) {
        double profit = 0;
        for (Rank rank : lottoResult.getLottoResult().keySet()) {
            profit += rank.getWinningMoney() * lottoResult.getLottoResult().getOrDefault(rank, 0);
        }

        return Math.floor(profit / (lottoAmount * LOTTO_PRICE) * 100) / 100;
    }
}
