package lotto.domain;

import java.util.Map;

public class Winnings {
    private int winningsPrice;

    public Winnings(LottoScore lottoScore) {
        this.winningsPrice = calculatorWinnings(lottoScore);
    }

    private int calculatorWinnings(LottoScore lottoScore) {
        Map<LottoWinnings, Integer> lottoScoreMap = lottoScore.getLottoScoreMap();
        for (Map.Entry<LottoWinnings, Integer> elem : lottoScoreMap.entrySet()) {
            winningsPrice += elem.getKey().getWinnings() * elem.getValue();
        }

        return winningsPrice;
    }

    public int getWinningsPrice() {
        return winningsPrice;
    }
}
