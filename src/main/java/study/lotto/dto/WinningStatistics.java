package study.lotto.dto;

import java.math.BigDecimal;
import java.util.List;

public class WinningStatistics {
    private final List<DivisionResult> divisionResultList;
    private final BigDecimal earningsRate;

    public WinningStatistics(List<DivisionResult> divisionResultList, BigDecimal earningsRate) {
        this.divisionResultList = divisionResultList;
        this.earningsRate = earningsRate;
    }

    public List<DivisionResult> getDivisionResultList() {
        return divisionResultList;
    }

    public BigDecimal getEarningsRate() {
        return earningsRate;
    }
}
