package study.lotto.model;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

public class WinningStatistics {

    private final IncomeRate incomeRate; // 당첨율
    private final RankStatistics rankStatistics; // 당첨 등수 통계

    private WinningStatistics(final TicketLotteryBundle ticketLotteryBundle, final WinningLottery winningLottery) {
        final List<Rank> refereedRanks = winningLottery.match(ticketLotteryBundle);
        final RankStatistics rankStatistics = RankStatistics.getInstance();
        final BigDecimal income = setUp(refereedRanks, rankStatistics);

        this.incomeRate = IncomeRate.valueOf(income, ticketLotteryBundle.size());
        this.rankStatistics = rankStatistics;
    }

    private BigDecimal setUp(List<Rank> refereedRanks, RankStatistics rankStatistics) {
        BigDecimal income = BigDecimal.ZERO;
        for (final Rank rank : refereedRanks) {
            final BigDecimal winningMoney = BigDecimal.valueOf(rank.getWinningMoney());
            income = income.add(winningMoney);
            rankStatistics.countUpByRank(rank);
        }
        return income;
    }

    public static WinningStatistics valueOf(final TicketLotteryBundle ticketLotteryBundle, final WinningLottery winningLottery) {
        return new WinningStatistics(ticketLotteryBundle, winningLottery);
    }

    public double getIncomeRate() {
        return incomeRate.getIncomeRate();
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return rankStatistics.getRankStatistics();
    }

    public int countByRank(final Rank rank) {
        return rankStatistics.countByRank(rank);
    }
}
