package study.lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderManualTicketLotteryBundle {
    private final List<OrderManualTicketLottery> orderManualTicketLotteryBundle = new ArrayList<>();

    private OrderManualTicketLotteryBundle(final List<Set<Integer>> orderManualTicketLotteryBundle) {
        for (final Set<Integer> numbers : orderManualTicketLotteryBundle) {
            this.orderManualTicketLotteryBundle.add(OrderManualTicketLottery.valueOf(numbers));
        }
    }

    public static OrderManualTicketLotteryBundle valueOf(final List<Set<Integer>> orderManualTicketLotteryBundle) {
        return new OrderManualTicketLotteryBundle(orderManualTicketLotteryBundle);
    }

    public int size() {
        return this.orderManualTicketLotteryBundle.size();
    }

    public List<TicketLottery> parseTicketLotteryList(final TicketLotteryType type) {
        final List<TicketLottery> ticketLotteryList = new ArrayList<>();
        for (final OrderManualTicketLottery orderManualTicketLottery : orderManualTicketLotteryBundle) {
            ticketLotteryList.add(orderManualTicketLottery.parseTicketLottery(type));
        }
        return ticketLotteryList;
    }
}
