package lotto.service;

import lotto.model.Ticket;
import lotto.model.Money;

public class LotteryClerk {
    private LotteryClerk() {
    }

    public static Ticket exchangeTicket(Money money) {
        return new Ticket(money);
    }
}
