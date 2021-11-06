package study.lotto.model;

public class LottoStore {

    protected static final int PRICE_OF_LOTTO_TICKET = 1_000;

    private LottoStore() {
    }

    public static TicketLotteryBundle orderTicketLotteryBundleByMoney(final int money) {
        final LotteryFactory lotteryFactory = LotteryFactory.getInstance();
        final int orderCount = getOrderCountByMoney(money);
        return lotteryFactory.generateTicketLotteryByCount(orderCount);
    }

    private static int getOrderCountByMoney(final int money) {
        return money / PRICE_OF_LOTTO_TICKET;
    }
}
