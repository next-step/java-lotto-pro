package lotto.type;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    NONE(-1, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int correctCount;
    private final int winningPrice;

    LottoRank(int correctCount, int winningPrice) {
        this.correctCount = correctCount;
        this.winningPrice = winningPrice;
    }

    public static LottoRank rankMatch(int matchCount, boolean bonusMatch) {
        if(matchCount == 5 && bonusMatch) {
            return LottoRank.FIVE_BONUS;
        }

        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.correctCount == matchCount)
            .findFirst()
            .orElse(NONE);
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCorrectCount() {
        return correctCount;
    }

}
