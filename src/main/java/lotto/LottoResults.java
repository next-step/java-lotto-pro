package lotto;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import view.Printable;

public class LottoResults implements Printable {
    private static final String DASH_SPACE = "- ";
    private static final String COUNTING_UNIT = "개";
    private static final String NEW_LINE = "\n";

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

    public EarningRate calculateEarningRate() {
        return LottoMoney.calculateEarningRate(resultCounts.entrySet().stream()
            .map(entry -> entry.getKey().calculateMultipleMoney(entry.getValue()))
            .collect(toList()));
    }

    @Override
    public String makePrintableMessage() {
        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> lottoResult != LottoResult.NONE)
            .map(lottoResult -> lottoResult.makePrintableMessage() + DASH_SPACE
                + resultCounts.getOrDefault(lottoResult, 0) + COUNTING_UNIT)
            .collect(Collectors.joining(NEW_LINE));
    }
}
