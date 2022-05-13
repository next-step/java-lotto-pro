package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DivisionResults {
    private final List<DivisionResult> divisionResultList;

    public DivisionResults(List<DivisionResult> divisionResultList) {
        this.divisionResultList = Arrays.asList(Division.values()).stream()
                .map(division -> findDivisionResult(division, divisionResultList))
                .collect(Collectors.toList());
    }

    public List<DivisionResult> getDivisionResultList() {
        return divisionResultList;
    }

    public BigDecimal getAllPrize() {
        return divisionResultList.stream()
                .map(DivisionResult::calculatePrize)
                .reduce(BigDecimal.ZERO, (prizeTotal1, prizeTotal2) -> prizeTotal1.add(prizeTotal2));
    }

    private DivisionResult findDivisionResult(Division division, List<DivisionResult> divisionResultList) {
        return divisionResultList.stream().filter(divisionResult -> divisionResult.isDivisionSame(division)).findFirst()
                .orElse(new DivisionResult(division));
    }

    @Override
    public String toString() {
        return "DivisionResults{" +
                "divisionResultList=" + divisionResultList +
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
        return Objects.equals(divisionResultList, that.divisionResultList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(divisionResultList);
    }
}
