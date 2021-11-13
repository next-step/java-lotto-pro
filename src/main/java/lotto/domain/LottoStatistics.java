package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoStatistics {
    private Map<LottoResult, Long> resultCounts;
    private EarningRate earningRate;

    public LottoStatistics(Map<LottoResult, Long> resultCounts, EarningRate earningRate) {
        this.resultCounts = resultCounts;
        this.earningRate = earningRate;
    }

    public Map<LottoResult, Long> getResultCounts() {
        return resultCounts;
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoStatistics)) {
            return false;
        }
        LottoStatistics that = (LottoStatistics)o;
        return Objects.equals(resultCounts, that.resultCounts) && Objects.equals(earningRate, that.earningRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCounts, earningRate);
    }
}
