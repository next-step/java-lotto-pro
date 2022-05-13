package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Prize, Integer> resultMap = new HashMap<>();
    private final double returnOfRatio;

    public LottoResult(final LottoTickets lottoTickets, final LottoNumbers winningNumbers) {
        returnOfRatio = 0;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "resultMap=" + resultMap +
                ", returnOfRatio=" + returnOfRatio +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoResult that = (LottoResult) o;
        return Double.compare(that.returnOfRatio, returnOfRatio) == 0 && Objects.equals(resultMap,
                that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap, returnOfRatio);
    }
}
