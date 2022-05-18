package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DrawResult {
    private final List<DivisionResult> value;

    public DrawResult(List<DivisionResult> divisionResultList) {
        this.value = createDivisionResultForAllDivision(divisionResultList);
    }

    public List<DivisionResult> getWinnings() {
        return value.stream()
                .map(DivisionResult::new)
                .collect(Collectors.toList());
    }

    public BigDecimal earningsRate(BigDecimal purchaseCost) {
        if (BigDecimal.ZERO.equals(purchaseCost)) {
            return BigDecimal.ONE;
        }
        return totalPrize().divide(purchaseCost, 2, BigDecimal.ROUND_DOWN);
    }

    private BigDecimal totalPrize() {
        return value.stream()
                .map(DivisionResult::calculatePrize)
                .reduce(BigDecimal.ZERO, (prize1, prize2) -> prize1.add(prize2));
    }

    private List<DivisionResult> createDivisionResultForAllDivision(List<DivisionResult> divisionResultList) {
        return Arrays.asList(Division.values()).stream()
                .filter(division -> division != Division.DIVISION_NONE)
                .map(division -> createDivisionResult(divisionResultList, division))
                .collect(Collectors.toList());
    }

    private DivisionResult createDivisionResult(List<DivisionResult> divisionResultList, Division division) {
        return divisionResultList.stream()
                .filter(divisionResult -> divisionResult.hasDivisionSame(division))
                .findFirst()
                .map(DivisionResult::new)
                .orElse(new DivisionResult(division));
    }

    @Override
    public String toString() {
        return "DrawResult{" +
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
        DrawResult that = (DrawResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
