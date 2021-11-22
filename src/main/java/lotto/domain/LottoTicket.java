package lotto.domain;

import static util.NumberUtils.*;
import java.util.ArrayList;
import java.util.Objects;
import lotto.component.LottoShuffleable;
import lotto.enums.Rank;

public class LottoTicket {
    private final Money money;
    private final Lotteries manualLotteries;
    private final Lotteries automationLotteries;
    private Lotteries totalLotteries;

    private final LottoShuffleable lottoShuffleable;

    public LottoTicket(final Money money, final Lotteries manualLotteries, final LottoShuffleable lottoShuffleable) {
        this.money = money;
        this.manualLotteries = manualLotteries;
        this.automationLotteries = new Lotteries(new ArrayList<>());
        this.lottoShuffleable = lottoShuffleable;
    }

    public void publish() {
        addAutomationLotteries();
        setTotalLotteries();
    }

    private void addAutomationLotteries() {
        final long automationLotteriesCount = countOfAutomationLotteries();

        for (int lottoCount = ZERO; lottoCount < automationLotteriesCount; lottoCount++) {
            this.automationLotteries.add(lottoShuffleable.shuffle());
        }
    }

    private long countOfAutomationLotteries() {
        return this.money.exchangeLottoPurchasableCount() - manualLotteries.size();
    }

    private void setTotalLotteries() {
        this.totalLotteries = Lotteries.of(this.manualLotteries, this.automationLotteries);
    }

    public Ranks toWinningRanks(final Lotto winningLotto, final BonusBall bonusBall) {
        final Ranks ranks = new Ranks();

        for (final Lotto lotto : this.totalLotteries.get()) {
            final int winningCount = lotto.findWinningCount(winningLotto);
            final Rank rank = Rank.valueOf(winningCount, bonusBall.isMatchedBy(lotto));

            ranks.put(rank, rank.exchangeCorrectCount(winningCount));
        }

        return ranks;
    }

    public int sizeOfTotalLotteries() {
        return this.totalLotteries.size();
    }

    public int sizeOfManualLotteries() {
        return this.manualLotteries.size();
    }

    public int sizeOfAutomationLotteries() {
        return this.automationLotteries.size();
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
        return Objects.equals(this.totalLotteries, that.totalLotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.totalLotteries);
    }

    @Override
    public String toString() {
        return this.totalLotteries.toString();
    }
}
