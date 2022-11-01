package step3.domain;

public class LottoUtil {

    private static final int LOTTO_PRICE = 1000;

    static public int buy(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

}
