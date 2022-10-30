package step3.model.machine;

import java.util.LinkedHashMap;
import java.util.Objects;
import step3.model.value.Rule;
import step3.view.OutputView;

public class Results {

    private final LinkedHashMap<Result, Integer> lottoResultMap;

    public Results() {
        lottoResultMap = new LinkedHashMap<>();
        for (Result result : Result.values()) {
            lottoResultMap.put(result, 0);
        }
    }

    public void recordResult(Result result) {
        lottoResultMap.put(result, lottoResultMap.get(result) + 1);
    }

    public Double evaluateResult(int ticketCount, long winningPrize) {
        if (ticketCount == 0) {
            return 0.0;
        }
        long totalPrice = ticketCount * Rule.TICKET_PRICE;
        return (double) winningPrize / totalPrice;
    }

    private long getTotalPrize(Result result) {
        return result.getTotalPrize(lottoResultMap.get(result));
    }

    public long getWinningPrize() {
        return lottoResultMap.keySet().stream().mapToLong(result -> getTotalPrize(result)).sum();
    }

    public void printResults() {
        lottoResultMap.keySet().stream()
                .filter(result -> result.isRewarded())
                .forEach(result -> OutputView.printResult(
                        result.toString(), Integer.toString(lottoResultMap.get(result))));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Results)) {
            return false;
        }
        Results results = (Results) o;
        return Objects.equals(lottoResultMap, results.lottoResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultMap);
    }
}
