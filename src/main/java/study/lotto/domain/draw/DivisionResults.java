package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DivisionResults {
    private final List<DivisionResult> value;

    public DivisionResults(List<DivisionResult> divisionResultList) {
        this.value = Arrays.asList(Division.values()).stream()
                .map(division -> findDivisionResult(division, divisionResultList))
                .collect(Collectors.toList());
    }

    public List<DivisionResult> get() {
        return value.stream()
                .map(DivisionResult::new)
                .collect(Collectors.toList());
    }

    public BigDecimal totalPrize() {
        return value.stream()
                .map(DivisionResult::calculatePrize)
                .reduce(BigDecimal.ZERO, (prizeTotal1, prizeTotal2) -> prizeTotal1.add(prizeTotal2));
    }

    private DivisionResult findDivisionResult(Division division, List<DivisionResult> divisionResultList) {
        return divisionResultList.stream()
                .filter(divisionResult -> divisionResult.hasDivisionSame(division))
                .findFirst()
                .map(DivisionResult::new)
                .orElse(new DivisionResult(division));
    }

    @Override
    public String toString() {
        return "DivisionResults{" +
                "value=" + value +
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
        DivisionResults that = (DivisionResults) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
