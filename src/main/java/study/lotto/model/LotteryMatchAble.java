package study.lotto.model;

import java.util.List;

public interface LotteryMatchAble {
    Rank match(final TicketLottery ticketLottery);
    List<Rank> match(final TicketLotteryBundle ticketLotteryBundle);
}
