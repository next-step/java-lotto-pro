package lotto;

public class LottoPrice {

    private static final int LOTTO_PRICE = 1000;


    public static int numberOfLottoCanBuy(int money) {
        return money / LOTTO_PRICE;
    }
}
