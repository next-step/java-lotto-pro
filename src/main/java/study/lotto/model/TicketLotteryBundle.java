package study.lotto.model;

import study.lotto.model.exception.TicketLotteryBundleMustBeNotEmptyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TicketLotteryBundle {
    private static final String TICKET_LOTTERY_BUNDLE_MUST_BE_NOT_EMPTY_ERROR_MESSAGE = "로또복권묶음은 최소 1개의 로또복권이 존재해야 합니다.";
    private final List<TicketLottery> ticketLotteries = new ArrayList<>();

    public TicketLotteryBundle() {
    }

    private TicketLotteryBundle(final List<TicketLottery> ticketLotteries) {
        validateNotEmpty(ticketLotteries);
        this.ticketLotteries.addAll(ticketLotteries);
    }

    private void validateNotEmpty(final List<TicketLottery> ticketLotteries) {
        if (ticketLotteries == null || ticketLotteries.isEmpty()) {
            throw new TicketLotteryBundleMustBeNotEmptyException(TICKET_LOTTERY_BUNDLE_MUST_BE_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    public static TicketLotteryBundle valueOf(final List<TicketLottery> ticketLotteries) {
        return new TicketLotteryBundle(ticketLotteries);
    }

    public static TicketLotteryBundle valueOf(final List<Set<Integer>> ticketLotteryBundle, final TicketLotteryType type) {
        final List<TicketLottery> ticketLotteries = new ArrayList<>();
        for (Set<Integer> numbers : ticketLotteryBundle) {
            ticketLotteries.add(TicketLottery.valueOf(numbers, type));
        }
        return TicketLotteryBundle.valueOf(ticketLotteries);
    }

    public static TicketLotteryBundle valueOf(OrderManualTicketLotteryBundle ticketLotteryBundle, TicketLotteryType type) {
        return new TicketLotteryBundle(ticketLotteryBundle.parseTicketLotteryList(type));
    }

    public void merge(final TicketLotteryBundle ticketLotteryBundle) {
        this.addAll(ticketLotteryBundle);
    }

    private void addAll(TicketLotteryBundle ticketLotteryBundle) {
        this.ticketLotteries.addAll(ticketLotteryBundle.ticketLotteries);
    }

    public List<TicketLottery> getTicketLotteries() {
        return Collections.unmodifiableList(ticketLotteries);
    }

    public int size() {
        return ticketLotteries.size();
    }

    public int getAutoTicketSize() {
        return (int) ticketLotteries.stream()
                .filter(ticketLottery -> ticketLottery.getType().isAutoTicket())
                .count();
    }

    public int getManualTicketSize() {
        return (int) ticketLotteries.stream()
                .filter(ticketLottery -> ticketLottery.getType().isManualTicket())
                .count();
    }
}
