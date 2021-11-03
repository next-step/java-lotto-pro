package lotto;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private int money;

    public LottoMoney(String moneyText) {
        money = Integer.parseInt(moneyText);
    }

    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }
}
