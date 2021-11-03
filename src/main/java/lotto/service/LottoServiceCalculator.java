package lotto.service;

import lotto.domain.LottoPrize;

import java.util.Map;

public class LottoServiceCalculator {

    private static final int LOTTO_PRICE = 1000;

    public static int getLottoCount(int boughtMoney) {
        return boughtMoney / LOTTO_PRICE;
    }

    public static double calculateProfitRate(Map<LottoPrize, Integer> lottoResultMap, int boughtMoney) {
        int winningMoney = calculateWinningMoney(lottoResultMap);
        return Math.floor((((double) winningMoney / boughtMoney) * 100)) / 100.0;
    }

    private static int calculateWinningMoney(Map<LottoPrize, Integer> lottoResultMap) {
        int winningMoney = 0;
        for (LottoPrize lottoPrize : lottoResultMap.keySet()) {
            winningMoney += lottoPrize.getMoney() * lottoResultMap.get(lottoPrize);
        }
        return winningMoney;
    }
}
