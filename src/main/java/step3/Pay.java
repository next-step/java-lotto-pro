package step3;

public class Pay {
    private static final int PRICE_LOTTO = 1000;

    public static int ableToBuyLottoCount(int money) {
        return money / PRICE_LOTTO;
    }
}
