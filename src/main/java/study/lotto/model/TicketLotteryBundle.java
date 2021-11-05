package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class TicketLotteryBundle {

    private final List<TicketLottery> ticketLotteries = new ArrayList<>();

    public int size() {
        return ticketLotteries.size();
    }

    private TicketLotteryBundle(final List<TicketLottery> ticketLotteries) {
        this.ticketLotteries.addAll(ticketLotteries);
    }

    public static TicketLotteryBundle valueOf(final List<TicketLottery> ticketLotteries) {
        return new TicketLotteryBundle(ticketLotteries);
    }
}
