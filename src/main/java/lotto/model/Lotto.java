package lotto.model;

import lotto.LottoConstants;

import java.util.List;

public class Lotto {
    private final LottoTicket ticket;

    private Lotto(LottoTicket ticket) {
        this.ticket = ticket;
    }

    public static int countPurchasable(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return (int) money.divideBy(LottoConstants.SELLING_PRICE);
    }

    public static Lotto generate(List<Integer> numbers) {
        return new Lotto(LottoTicket.of(numbers));
    }

    @Override
    public String toString() {
        return ticket.toString();
    }

    public Winning calculateWinning(WinTicket winTicket) {
        final int count = ticket.calculateNumberOfMatch(winTicket);
        Winning winning = Winning.ofMatchCount(count);
        if (winning.needBonus()
                && !ticket.contains(winTicket.getBonusNumber())) {
            winning = Winning.THIRD_PRIZE;
        }
        return winning;
    }
}
