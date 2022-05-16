package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoScore {

    private static final Integer ZERO = 0;
    private Map<LottoWinnings, Integer> lottoScoreMap;

    public LottoScore() {
        lottoScoreMap = defaultLottoScoreMap();
    }

    private Map<LottoWinnings, Integer> defaultLottoScoreMap() {
        this.lottoScoreMap = new HashMap<>();

        for (LottoWinnings lottoWinnings : LottoWinnings.scoreTypes()) {
            lottoScoreMap.put(lottoWinnings, ZERO);
        }

        return lottoScoreMap;
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
        int winnings = 0;

        for (Map.Entry<LottoWinnings, Integer> elem : lottoScoreMap.entrySet()) {
            winnings += elem.getKey().getWinnings() * elem.getValue();
        }

        return new Winnings(winnings);
    }
}
