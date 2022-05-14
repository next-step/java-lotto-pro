package lotto.view.model;

import static lotto.view.constants.LottoConstant.LOTTO_PRICE;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        checkAmountRange(amount);
        checkAmountUnit(amount);
        return new Money(amount);
    }

    private static void checkAmountRange(int amount) {
        if (amount < 0) {
            String message = String.format("[ERROR] 구매금액은 음수일 수 없습니다! : 입력금액 [%d]", amount);
            throw new IllegalArgumentException(message);
        }
    }

    private static void checkAmountUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            String message = String.format("[ERROR] 구매금액은 %s원 단위만 가능합니다! : 입력금액 [%d]", LOTTO_PRICE, amount);
            throw new IllegalArgumentException(message);
        }
    }
}
