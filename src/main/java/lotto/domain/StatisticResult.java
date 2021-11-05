package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class StatisticResult {

    private Map<Integer, Integer> store;

    public StatisticResult() {
        store = new HashMap<>();
    }

    public void report(int correspondCount) {
        store.merge(correspondCount, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public int get(int key) {
        return store.getOrDefault(key, 0);
    }
}
