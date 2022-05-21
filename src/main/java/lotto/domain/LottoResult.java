package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(int sameNumberCount) {
        result.put(sameNumberCount, result.getOrDefault(sameNumberCount, 0) + 1);
    }

    public Map<Integer, Integer> getScore() {
        return new HashMap<>(this.result);
    }

}
