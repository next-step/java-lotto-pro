package study.lotto.model;

import java.util.List;

public interface LotteryMatchAble {
    List<Rank> match(final TicketLotteryBundle ticketLotteryBundle);
}
