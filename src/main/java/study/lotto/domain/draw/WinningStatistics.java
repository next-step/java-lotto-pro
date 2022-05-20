package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;

public class WinningStatistics {
    private final List<DivisionResult> divisionResults;
    private final BigDecimal earningsRate;

    public WinningStatistics(DrawResult drawResult, LottoPurchaseHistory lottoPurchaseHistory) {
        this.divisionResults = drawResult.getWinnings();
        this.earningsRate = drawResult.earningsRate(lottoPurchaseHistory.getTotalCost());
    }

    public List<DivisionResult> getDivisionResults() {
        return divisionResults.stream()
                .map(DivisionResult::new)
                .collect(Collectors.toList());
    }

    public BigDecimal getEarningsRate() {
        return earningsRate;
    }
}
