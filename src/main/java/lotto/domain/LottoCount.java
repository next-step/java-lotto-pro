package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoCount {
    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int count) {
        return new LottoCount(count);
    }

    public static LottoCount calculateBy(Money money) {
        return LottoCount.from(money.getMoney() / LOTTO_PRICE);
    }

    public int getCount() {
        return this.count;
    }
}
