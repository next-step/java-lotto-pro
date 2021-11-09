package study.lotto.model;

public class LottoStore {

    public static final int PRICE_OF_LOTTO_TICKET = 1_000;

    private LottoStore() {
    }

    public static TicketLotteryBundle orderTicketLotteryBundleByMoney(final Money money) {
        final TicketOrderCount orderCount = TicketOrderCount.valueOf(money);
        return LotteryFactory.generateAutoTicketLotteryBundleByCount(orderCount);
    }
}
