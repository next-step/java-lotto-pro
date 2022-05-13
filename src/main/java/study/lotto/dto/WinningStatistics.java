package study.lotto.dto;

import java.math.BigDecimal;
import java.util.List;
import study.lotto.domain.draw.DrawResult;

public class WinningStatistics {
    private final List<DivisionDetails> divisionDetailsList;
    private final BigDecimal earningsRate;

    public WinningStatistics(List<DivisionDetails> divisionDetailsList, BigDecimal earningsRate) {
        this.divisionDetailsList = divisionDetailsList;
        this.earningsRate = earningsRate;
    }

    public static WinningStatistics of(DrawResult drawResult, BigDecimal purchaseCost) {
        return new WinningStatistics(DivisionDetails.from(drawResult), drawResult.earningsRate(purchaseCost));
    }

    public List<DivisionDetails> getDivisionResultList() {
        return divisionDetailsList;
    }

    public BigDecimal getEarningsRate() {
        return earningsRate;
    }
}
