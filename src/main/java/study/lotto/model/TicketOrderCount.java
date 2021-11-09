package study.lotto.model;

import study.lotto.model.exception.IllegalTicketOrderCountException;

import java.util.stream.IntStream;

public class TicketOrderCount {
    private static final int DEFAULT_LOW_BOUND = 0;
    private static final int MIN_VALUE = 1;
    private static final String MIN_ORDER_ERROR_MESSAGE_TEMPLATE = "최소 %d개의 주문갯수가 필요합니다.";
    private final int orderCount;

    private TicketOrderCount(final Money money) {
        this(money.divideByPriceOfLottoTicket());
    }

    public TicketOrderCount(int orderCount) {
        validate(orderCount);
        this.orderCount = orderCount;
    }

    private void validate(final int orderCount) {
        if (orderCount < MIN_VALUE) {
            throw new IllegalTicketOrderCountException(String.format(MIN_ORDER_ERROR_MESSAGE_TEMPLATE, MIN_VALUE));
        }
    }

    public static TicketOrderCount valueOf(final Money money) {
        return new TicketOrderCount(money);
    }

    public static TicketOrderCount valueOf(final int orderCount) {
        return new TicketOrderCount(orderCount);
    }

    public IntStream getStream() {
        return IntStream.range(DEFAULT_LOW_BOUND, orderCount);
    }
}
