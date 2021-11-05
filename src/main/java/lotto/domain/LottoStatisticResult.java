package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
}
