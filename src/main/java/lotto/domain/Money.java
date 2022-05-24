package lotto.domain;

import lotto.message.InputMessage;

public class Money {
    private final int money;

    public Money(int money) {
        validateMinimum(money);
        this.money = money;
    }

    private void validateMinimum(int money) {
        if (money < LottoTicket.PRICE) {
            throw new IllegalArgumentException(InputMessage.INVALID_MINIMUM_MONEY);
        }
    }

    public int ticketCount() {
        return money / LottoTicket.PRICE;
    }

    public int getMoney() {
        return money;
    }
}
