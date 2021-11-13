package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import step3.component.LottoShuffleable;
import step3.enums.Prize;
import step3.enums.Prizes;

public class LottoTicket {

    private final List<Lotto> lotteries = new ArrayList<>();

    public void publish(final Money money, final LottoShuffleable lottoShuffleable) {
        final long publishCount = money.exchangeLottoPurchasableCount();

        for (int lottoCount = 0; lottoCount < publishCount; lottoCount++) {
            lotteries.add(lottoShuffleable.shuffle());
        }
    }

    public List<Lotto> get() {
        return this.lotteries;
    }

    public Prizes toWinningPrizes(final Lotto winningLotto) {
        final Prizes prizes = new Prizes();

        for (Lotto lotto : this.lotteries) {
            prizes.add(Prize.of(lotto.findWinningCount(winningLotto)));
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
}
