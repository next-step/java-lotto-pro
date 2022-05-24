package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<Rank, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(Rank.class);
    }

    public void add(int sameNumberCount, boolean matchBonus) {
        Rank rank = Rank.valueOf(sameNumberCount, matchBonus);
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getScore() {
        return new EnumMap<>(this.result);
    }

}
