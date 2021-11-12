package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Objects;

public class LottoResults {
    private final List<LottoResult> results;

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public List<LottoResult> getResults() {
        return results;
    }

    public EarningRate calculateEarningRate() {
        return LottoMoney.calculateEarningRate(results.stream().map(LottoResult::getLottoMoney).collect(toList()));
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
