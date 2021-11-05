package lotto;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class LottoResults {
    private final Map<LottoResult, Integer> resultCounts;

    public LottoResults(List<LottoResult> lottoResults) {
        this.resultCounts = lottoResults.stream()
            .collect(groupingBy(Function.identity(), reducing(0, e -> 1, Integer::sum)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoResults)) {
            return false;
        }
        LottoResults that = (LottoResults)o;
        return Objects.equals(resultCounts, that.resultCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCounts);
    }
}
