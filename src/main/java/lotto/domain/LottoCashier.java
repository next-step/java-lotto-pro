package lotto.domain;

public class LottoCashier {
    private static final Money DEFAULT_PRICE = Money.of(1000);

    private final LottoPrinter lottoPrinter;

    public LottoCashier(LottoPrinter lottoPrinter) {
        this.lottoPrinter = lottoPrinter;
    }

    public LotteryTicket buy(Money cash) {
        validateDefaultPrice(cash);
        int count = cash.getDividedIntValue(DEFAULT_PRICE);
        return new LotteryTicket(lottoPrinter.print(count));
    }

    private static void validateDefaultPrice(Money cash) {
        if (cash.isLessThan(DEFAULT_PRICE) || !cash.isModResultZero(DEFAULT_PRICE)) {
            throw new IllegalArgumentException(String.format("%d원 단위로 구매하실 수 있습니다", DEFAULT_PRICE.intValue()));
        }
    }

    public boolean isPossibleToBuy(Money cash, int count) {
        if (count == 0) {
            return true;
        }
        Money wanted = DEFAULT_PRICE.multiply(count);
        return cash.getDividedIntValue(wanted) >= count;
    }
}
