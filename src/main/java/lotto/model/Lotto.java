package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final Money SELLING_PRICE = new Money(1000);

    private final LottoTicket ticket;

    private Lotto(LottoTicket ticket) {
        this.ticket = ticket;
    }

    public static int getNumberOfLottosPurchasableWith(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return (int) money.divideBy(SELLING_PRICE);
    }

    public static Lotto generate(List<Integer> numbers) {
        final List<LottoNumber> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(new LottoNumber(number));
        }
        return new Lotto(new LottoTicket(list));
    }

    @Override
    public String toString() {
        return ticket.toString();
    }

    public Winning calculateWinning(WinTicket winTicket) {
        final int count = ticket.calculateNumberOfMatch(winTicket);
        return Winning.ofMatchCount(count);
    }

    public Money getSellingPrice() {
        return SELLING_PRICE;
    }
}
