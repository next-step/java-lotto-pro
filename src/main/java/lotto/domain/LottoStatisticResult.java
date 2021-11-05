package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatisticResult {

    private Map<Integer, Integer> store;

    public LottoStatisticResult() {
        store = new HashMap<>();
    }

    public void report(int correspondCount) {
        store.merge(correspondCount, 1, (oldValue, newValue) -> oldValue + 1);
    }

    public int get(int key) {
        return store.getOrDefault(key, 0);
    }
}
