package step3.domain;

import static util.NumberUtils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import step3.component.LottoShuffleable;
import step3.enums.Prize;

public class LottoTicket {

    private final List<Lotto> lotteries = new ArrayList<>();

    public void publish(final Money money, final LottoShuffleable lottoShuffleable) {
        final long publishCount = money.exchangeLottoPurchasableCount();

        for (int lottoCount = ZERO; lottoCount < publishCount; lottoCount++) {
            lotteries.add(lottoShuffleable.shuffle());
        }
    }

    public int size() {
        return this.lotteries.size();
    }

    public Prizes toWinningPrizes(final Lotto winningLotto) {
        final Prizes prizes = new Prizes();

        for (Lotto lotto : this.lotteries) {
            final int winningCount = lotto.findWinningCount(winningLotto);
            final Prize prize = Prize.of(winningCount);

            prizes.put(prize, prize.exchangeCorrectCount(winningCount));
        }

        return prizes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicket)) {
            return false;
        }
        final LottoTicket that = (LottoTicket)o;
        return Objects.equals(lotteries, that.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for (final Lotto lotto : this.lotteries) {
            joiner.add(lotto.toString());
        }

        return joiner.toString();
    }
}
