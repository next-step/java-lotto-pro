package lotto.domain;

import static util.NumberUtils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lotto.component.LottoShuffleable;
import lotto.enums.Rank;

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

    public Ranks toWinningRanks(final Lotto winningLotto) {
        final Ranks ranks = new Ranks();

        for (Lotto lotto : this.lotteries) {
            final int winningCount = lotto.findWinningCount(winningLotto);
            final Rank rank = Rank.of(winningCount);

            ranks.put(rank, rank.exchangeCorrectCount(winningCount));
        }

        return ranks;
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
