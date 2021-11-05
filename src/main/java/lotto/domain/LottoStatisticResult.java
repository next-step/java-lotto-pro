package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class LottoStatisticResult {

    private Map<Integer, Integer> statistic;

    public LottoStatisticResult() {
        statistic = new HashMap<>();
    }

    public void report(int correspondCount) {
        statistic.merge(correspondCount, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public int get(int key) {
        return statistic.getOrDefault(key, 0);
    }

    public Map<Integer, Integer> gets(List<Integer> keys) {
        return keys.stream()
                .collect(toMap(Function.identity(), k -> statistic.getOrDefault(k, 0)));
    }

}
