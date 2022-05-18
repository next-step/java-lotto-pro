package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Objects;

public class DivisionResult {
    private final Division division;
    private final Long count;

    public DivisionResult(Division division) {
        this(division, 0L);
    }

    public DivisionResult(DivisionResult divisionResult) {
        this(divisionResult.division, divisionResult.count);
    }

    public DivisionResult(Division division, Long count) {
        this.division = division;
        this.count = count;
    }

    public BigDecimal calculatePrize() {
        return division.getPrize().multiply(BigDecimal.valueOf(count));
    }

    public boolean hasDivisionSame(Division division) {
        return this.division == division;
    }

    public Division getDivision() {
        return division;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "DivisionResult{" +
                "division=" + division +
                ", count=" + count +
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
        DivisionResult that = (DivisionResult) o;
        return division == that.division && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(division, count);
    }
}
