package lotto.type;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
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

    public static Optional<LottoRank> rankMatch(int matchCount, boolean bonusMatch) {
        if(matchCount == 5 && bonusMatch) {
            return Optional.of(LottoRank.FIVE_BONUS);
        }

        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.correctCount == matchCount)
            .findFirst();
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCorrectCount() {
        return correctCount;
    }

}
