package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoScore {
    private final Map<LottoWinnings, Integer> lottoScoreMap;

    public LottoScore() {
        this.lottoScoreMap = new HashMap<>();
    }

    public Map<LottoWinnings, Integer> getLottoScoreMap() {
        return Collections.unmodifiableMap(lottoScoreMap);
    }

    public void addScore(LottoWinnings lottoWinnings) {
        if (lottoScoreMap.get(lottoWinnings) != null) {
            int count = lottoScoreMap.get(lottoWinnings);
            lottoScoreMap.put(lottoWinnings, ++count);
            return;
        }

        lottoScoreMap.put(lottoWinnings, 1);
    }

    public Winnings getWinnings() {
        return new Winnings(this);
    }
}
