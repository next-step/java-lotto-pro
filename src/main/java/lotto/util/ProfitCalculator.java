package lotto.util;

import lotto.domain.LottoResult;

import static lotto.domain.PayAmount.LOTTO_PRICE;

public class ProfitCalculator {

    public static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    public static final int MIN_WINNING_NUM = 3;

    public static double calculateProfit(LottoResult lottoResult, int lottoAmount) {
        double profit = 0;
        for (int i = MIN_WINNING_NUM; i < PRIZE_MONEY.length; i++) {
            profit += lottoResult.getLottoResult(i) * PRIZE_MONEY[i];
        }

        return Math.floor(profit / (lottoAmount * LOTTO_PRICE) * 100) / 100;
    }
}
