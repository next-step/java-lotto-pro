package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void putPrize(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Integer matches(int count) {
        Prize prize = Prize.of(count);
        return result.get(prize);
    }
}
