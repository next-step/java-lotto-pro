package study.lotto.model;

public class LottoStore {

    public static final Money PRICE_OF_LOTTO_TICKET = Money.valueOf(1_000);

    private LottoStore() {
    }

    public static LottoStore getInstance() {
        return new LottoStore();
    }

    public void sellTo(final Customer customer) {
        customer.buy(this);
    }

    public boolean orderAutoTicketAble(Money money) {
        return money.greaterThan(PRICE_OF_LOTTO_TICKET);
    }

    public boolean orderManualTicketAble(final OrderManualTicketLotteryBundle manualLottoNumbers, final Money money) {
        final int orderCount = manualLottoNumbers.size();
        return money.greaterThan(PRICE_OF_LOTTO_TICKET.multiply(orderCount));
    }

    public OrderResult orderAutoTicketLotteryBundle(final Money money) {
        final TicketOrderCount orderCount = TicketOrderCount.valueOf(money);
        final Money fee = getFee(orderCount);
        final TicketLotteryBundle ticketLotteryBundle = LotteryFactory.generateAutoTicketLotteryBundleByCount(orderCount);
        return OrderResult.valueOf(ticketLotteryBundle, fee);
    }

    public OrderResult orderManualTicketLotteryBundle(final OrderManualTicketLotteryBundle manualLottoNumbers) {
        final TicketOrderCount orderCount = TicketOrderCount.valueOf(manualLottoNumbers.size());
        final Money fee = getFee(orderCount);
        final TicketLotteryBundle ticketLotteryBundle = LotteryFactory.generateManualTicketLotteryBundle(manualLottoNumbers);
        return OrderResult.valueOf(ticketLotteryBundle, fee);
    }

    private Money getFee(final TicketOrderCount orderCount) {
        return PRICE_OF_LOTTO_TICKET.multiply(orderCount.intValue());
    }


}
