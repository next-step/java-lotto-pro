package lotto.domain;

import java.util.List;

public class LottoCashier {
    private static final Money DEFAULT_PRICE = Money.of(1000);

    private final LottoPrinter lottoPrinter;

    public LottoCashier(LottoPrinter lottoPrinter) {
        this.lottoPrinter = lottoPrinter;
    }

    public List<LottoNumbers> buy(Money cash) {
        validateDefaultPrice(cash);
        int count = cash.divide(DEFAULT_PRICE).intValue();
        return lottoPrinter.print(count);
    }

    private static void validateDefaultPrice(Money cash) {
        if (cash.isLessThan(DEFAULT_PRICE) || !cash.isModResultZero(DEFAULT_PRICE)) {
            throw new IllegalArgumentException(String.format("%d원 단위로 구매하실 수 있습니다", DEFAULT_PRICE.intValue()));
        }
    }
}
