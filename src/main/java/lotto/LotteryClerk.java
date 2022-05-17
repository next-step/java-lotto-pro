package lotto;

import lotto.vo.Ticket;
import lotto.vo.Money;

public class LotteryClerk {
    private LotteryClerk() {
    }

    public static Ticket exchangeTicket(Money money) {
        return new Ticket(money);
    }
}
