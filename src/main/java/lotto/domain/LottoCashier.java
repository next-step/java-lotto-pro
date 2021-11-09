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

    public LotteryTicket buy(Money cash, String[] texts) {
        validateDefaultPrice(cash);
        validatePossibleToBuy(cash, texts);
        return new LotteryTicket(texts);
    }

    private void validatePossibleToBuy(Money cash, String[] text) {
        if (!isPossibleToBuy(cash, text.length)) {
            throw new IllegalArgumentException("복권을 살 수 있는 금액이 부족합니다");
        }
    }

    private static void validateDefaultPrice(Money cash) {
        if (cash.isLessThan(DEFAULT_PRICE) || !cash.isModResultZero(DEFAULT_PRICE)) {
            throw new IllegalArgumentException(String.format("%d원 단위로 구매하실 수 있습니다", DEFAULT_PRICE.intValue()));
        }
    }

    public boolean isPossibleToBuy(Money cash, int count) {
        return cash.getDividedIntValue(DEFAULT_PRICE) >= count;
    }
}
