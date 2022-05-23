package lotto.domain;

import lotto.message.InputMessage;

import static lotto.domain.LottoStore.LOTTO_PRICE;

public class Money {
    private final int money;

    public Money(int money) {
        validateMinimum(money);
        this.money = money;
    }

    private void validateMinimum(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(InputMessage.INVALID_MINIMUM_MONEY);
        }
    }

    public int ticketCount() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
