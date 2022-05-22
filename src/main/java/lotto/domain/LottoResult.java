package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(int sameNumberCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(sameNumberCount, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getScore() {
        return new HashMap<>(this.result);
    }

}
