package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class LottoResults {
    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public List<LottoResult> getResults() {
        return results;
    }

    public LottoStatistics makeStatistics() {
        Map<LottoResult, Long> resultCounts = results.stream()
            .collect(groupingBy(Function.identity(), counting()));

        EarningRate earningRate = LottoMoney.calculateEarningRate(
            results.stream().map(LottoResult::getLottoMoney).collect(toList()));

        return new LottoStatistics(resultCounts, earningRate);
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
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
