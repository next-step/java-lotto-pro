package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketLotteryBundle {
    private static final String TICKET_LOTTERY_BUNDLE_MUST_BE_NOT_EMPTY_ERROR_MESSAGE = "로또복권묶음은 최소 1개의 로또복권이 존재해야 합니다.";
    private final List<TicketLottery> ticketLotteries = new ArrayList<>();

    public int size() {
        return ticketLotteries.size();
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

    public List<TicketLottery> getTicketLotteries() {
        return Collections.unmodifiableList(ticketLotteries);
    }

}
