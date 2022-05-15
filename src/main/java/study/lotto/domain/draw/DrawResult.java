package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class DrawResult {
    private final DivisionResults divisionResult;

    public DrawResult(DivisionResults divisionResult) {
        this.divisionResult = divisionResult;
    }

    public BigDecimal earningsRate(BigDecimal lottoExpense) {
        if (BigDecimal.ZERO.equals(lottoExpense)) {
            return BigDecimal.ONE;
        }
        return divisionResult.totalPrize().divide(lottoExpense, 2, BigDecimal.ROUND_DOWN);
    }

    public List<DivisionResult> get() {
        return divisionResult.get();
    }

    @Override
    public String toString() {
        return "DrawResult{" +
                "divisionResult=" + divisionResult +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrawResult that = (DrawResult) o;
        return Objects.equals(divisionResult, that.divisionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisionResult);
    }
}
