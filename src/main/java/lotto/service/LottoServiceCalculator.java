package lotto.service;

public class LottoServiceCalculator {

    private static final int LOTTO_PRICE = 1000;

    public static int getLottoCount(int boughtMoney) {
        return boughtMoney / LOTTO_PRICE;
    }
}
