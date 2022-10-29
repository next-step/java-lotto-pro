package lotto;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoGame(int money) {
        this.money = money;
    }

    public int countPurchase() {
        return money / LOTTO_PRICE;
    }
}
