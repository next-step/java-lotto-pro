package study.lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Customer {

    private Money money;
    private final OrderManualTicketLotteryBundle orderManualTicketLotteryBundle;
    private final TicketLotteryBundle ticketLotteryBundle = new TicketLotteryBundle();

    private Customer(final int money, final List<Set<Integer>> orderManualTicketLotteryBundle) {
        this.money = Money.valueOf(money);
        this.orderManualTicketLotteryBundle = OrderManualTicketLotteryBundle.valueOf(orderManualTicketLotteryBundle);
    }

    public static Customer valueOf(final int money, List<Set<Integer>> manualTicketLotteryBundle) {
        return new Customer(money, manualTicketLotteryBundle);
    }

    public void buy(final LottoStore lottoStore) {
        if (lottoStore.orderManualTicketAble(orderManualTicketLotteryBundle, money)) {
            buyManualTicketBundle(lottoStore);
        }
        if (lottoStore.orderAutoTicketAble(money)) {
            buyAutoTicketBundle(lottoStore);
        }
    }

    private void buyAutoTicketBundle(final LottoStore lottoStore) {
        final OrderResult orderResult = lottoStore.orderAutoTicketLotteryBundle(money);
        this.money = orderResult.changeMoney(money);
        orderResult.merge(ticketLotteryBundle);
    }

    private void buyManualTicketBundle(final LottoStore lottoStore) {
        final OrderResult orderResult = lottoStore.orderManualTicketLotteryBundle(orderManualTicketLotteryBundle);
        this.money = orderResult.changeMoney(money);
        orderResult.merge(ticketLotteryBundle);
    }

    public List<TicketLottery> getTicketLotteries() {
        return Collections.unmodifiableList(ticketLotteryBundle.getTicketLotteries());
    }

    public int getAutoTicketSize() {
        return ticketLotteryBundle.getAutoTicketSize();
    }

    public int getManualTicketSize() {
        return ticketLotteryBundle.getManualTicketSize();
    }
}
