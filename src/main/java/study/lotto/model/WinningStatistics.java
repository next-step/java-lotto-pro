package study.lotto.model;

import java.math.BigDecimal;
import java.util.List;

public class WinningStatistics {

    private final IncomeRate incomeRate; // 당첨율
    private final RankStatistics rankStatistics; // 당첨 등수 통계

    private WinningStatistics(final TicketLotteryBundle ticketLotteryBundle, final WinningLottery winningLottery) {

        final List<Rank> refereedRanks = LottoDiscriminator.referee(winningLottery, ticketLotteryBundle);

        BigDecimal income = BigDecimal.ZERO;
        final RankStatistics rankStatistics = RankStatistics.getInstance();
        for (final Rank rank : refereedRanks) {
            final BigDecimal winningMoney = BigDecimal.valueOf(rank.getWinningMoney());
            income = income.add(winningMoney);
            rankStatistics.countUpByRank(rank);
        }

        final int ticketCount = ticketLotteryBundle.size();
        this.incomeRate = IncomeRate.valueOf(income, ticketCount);
        this.rankStatistics = rankStatistics;
    }

    public static WinningStatistics valueOf(final TicketLotteryBundle ticketLotteryBundle, final WinningLottery winningLottery) {
        return new WinningStatistics(ticketLotteryBundle, winningLottery);
    }

    public double getIncomeRate() {
        return incomeRate.getIncomeRate();
    }

    public RankStatistics getRankStatistics() {
        return rankStatistics;
    }
}
