package study.lotto.model;

public class LottoStore {

    protected static final int PRICE_OF_LOTTO_TICKET = 1_000;

    private LottoStore() {
    }

    public static TicketLotteryBundle orderTicketLotteryBundleByMoney(final Money money) {
        final LotteryFactory lotteryFactory = LotteryFactory.getInstance();
        final int orderCount = calcOrderCountByMoney(money);
        return lotteryFactory.generateTicketLotteryBundleByCount(orderCount);
    }

    private static int calcOrderCountByMoney(final Money money) {
        return money.getMoney() / PRICE_OF_LOTTO_TICKET;
//        return money.divide(PRICE_OF_LOTTO_TICKET);
    }
}
