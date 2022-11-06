package step3.domain;

public class LottoUtil {

    private static final int LOTTO_PRICE = 1000;

    private LottoUtil() {
    }

    public static int buy(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public static int add(int cnt) {
        return cnt * LOTTO_PRICE;
    }

}
