package lotto.domain;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public static LottoGame sell(Money money) {
        int tryCount = money.calculateTryLottoCount(money, LOTTO_PRICE);
        return new LottoGame(tryCount);
    }
}
