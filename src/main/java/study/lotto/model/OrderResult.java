package study.lotto.model;

import java.util.List;
import java.util.Set;

public class OrderResult {

    private final TicketLotteryBundle ticketLotteryBundle;
    private final Money fee;

    public OrderResult(final TicketLotteryBundle ticketLotteryBundle, final Money fee) {
        this.ticketLotteryBundle = ticketLotteryBundle;
        this.fee = fee;
    }

    public OrderResult(final List<Set<Integer>> ticketLotteryBundle, final TicketLotteryType type, final int fee) {
        this.ticketLotteryBundle = TicketLotteryBundle.valueOf(ticketLotteryBundle, type);
        this.fee = Money.valueOf(fee);
    }

    public static OrderResult valueOf(final TicketLotteryBundle ticketLotteryBundle, final Money fee) {
        return new OrderResult(ticketLotteryBundle, fee);
    }

    public static OrderResult valueOf(final List<Set<Integer>> ticketLotteryBundle, final TicketLotteryType type, final int fee) {
        return new OrderResult(ticketLotteryBundle, type, fee);
    }

    public TicketLotteryBundle getTicketLotteryBundle() {
        return ticketLotteryBundle;
    }

    public int size() {
        return this.ticketLotteryBundle.size();
    }

    public Money changeMoney(final Money money) {
        return money.minus(this.fee);
    }

    public void merge(final TicketLotteryBundle ticketLotteryBundle) {
        ticketLotteryBundle.merge(this.ticketLotteryBundle);
    }
}
