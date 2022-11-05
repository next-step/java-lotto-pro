package lotto.ui.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.statistics.MatchingResult;

public class WinningStatisticsOutput {
    private final List<MatchingCount> matchingCounts;
    private final BigDecimal returnOnInvestment;

    public WinningStatisticsOutput(MatchingResult matchingResult) {
        this.matchingCounts = matchingResult.toMap()
                .entrySet()
                .stream()
                .map(entry -> new MatchingCount(entry.getKey(), entry.getValue()))
                .sorted()
                .collect(Collectors.toList());
        this.returnOnInvestment = matchingResult.computeReturnOnInvestment();
    }

    public BigDecimal getReturnOnInvestment() {
        return this.returnOnInvestment;
    }

    public List<MatchingCount> getMatchingCounts() {
        return this.matchingCounts;
    }
}
