package lotto.service;

public class LottoServiceCalculator {

    private static final int LOTTO_PRICE = 1000;

    public static int getLottoCount(int boughtMoney) {
        return boughtMoney / LOTTO_PRICE;
    }

    public static double calculateProfitRate(int winningMoney, int boughtMoney) {
        return Math.floor((((double) winningMoney / boughtMoney) * 100)) / 100.0;
    }
}
