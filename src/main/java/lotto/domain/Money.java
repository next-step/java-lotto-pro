package lotto.domain;

import lotto.view.OutputView;

public class Money {
    private final int money;

    public Money(int money) {
        if (!isValid(money)) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public static boolean isValid(int money) {
        if (money < 0) {
            OutputView.print("투입 금액은 0 이상의 숫자만 가능합니다.");
            return false;
        }
        if (money % Lotto.LOTTO_PRICE != 0) {
            OutputView.print("투입 금액은 1000 단위의 숫자만 가능합니다.");
            return false;
        }
        return true;
    }

    public int getBuyableLottoCount() {
        return this.money / Lotto.LOTTO_PRICE;
    }
}
