package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final Money SELLING_PRICE = new Money(1000);

    private final LottoTicket ticket;

    private Lotto(LottoTicket ticket) {
        this.ticket = ticket;
    }

    public static int countPurchasable(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return (int) money.divideBy(SELLING_PRICE);
    }

    public static Lotto generate(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(new LottoTicket(lottoNumbers));
    }

    @Override
    public String toString() {
        return ticket.toString();
    }

    public Winning calculateWinning(WinTicket winTicket) {
        final int count = ticket.calculateNumberOfMatch(winTicket);
        return Winning.ofMatchCount(count);
    }
}
