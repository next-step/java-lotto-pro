package study.lotto.controller.dto;

import study.lotto.model.Rank;
import study.lotto.model.WinningStatistics;

import java.util.EnumMap;

public class WinningStatisticsResponseDto {
    private final double incomeRate;
    private final EnumMap<Rank, Integer> rankStatistics;

    public WinningStatisticsResponseDto(final WinningStatistics winningStatistics) {
        this.incomeRate = winningStatistics.getIncomeRate();
        this.rankStatistics = winningStatistics.getRankStatistics();
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return rankStatistics;
    }

    public double getIncomeRate() {
        return incomeRate;
    }
}
