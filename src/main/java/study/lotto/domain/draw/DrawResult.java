package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class DrawResult {
    private final Map<Division, Long> divisionResult;

    public DrawResult(Map<Division, Long> divisionResult) {
        this.divisionResult = divisionResult;
    }

    public int numberOfWin(Division division) {
        return divisionResult.get(division).intValue();
    }

    public Map<Division, Long> get() {
        return divisionResult;
    }

    public BigDecimal getAllPrize() {
        return divisionResult.entrySet().stream()
                .map(this::getPrizeTotal)
                .reduce(BigDecimal.ZERO, (prizeTotal1, prizeTotal2) -> prizeTotal1.add(prizeTotal2));
    }

    private BigDecimal getPrizeTotal(Entry<Division, Long> entry) {
        return entry.getKey().getPrize().multiply(new BigDecimal(entry.getValue()));
    }

    public BigDecimal earningsRate(BigDecimal lottoExpense) {
        return getAllPrize().divide(lottoExpense, 2, BigDecimal.ROUND_DOWN);
    }
}
