package lotto;

import lotto.domain.Ticket;
import lotto.domain.Money;

public class LotteryClerk {
    private LotteryClerk() {
    }

    public static Ticket exchangeTicket(Money money) {
        return new Ticket(money);
    }
}
