package lotto.type;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinningPriceType {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int correctCount;
    private final int winningPrice;

    LottoWinningPriceType(int correctCount, int winningPrice) {
        this.correctCount = correctCount;
        this.winningPrice = winningPrice;
    }

    public static Optional<LottoWinningPriceType> getByCorrectCount(int correctCount) {
        return Arrays.stream(LottoWinningPriceType.values())
            .filter(lottoWinningPriceType -> lottoWinningPriceType.correctCount == correctCount)
            .findFirst();
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCorrectCount() {
        return correctCount;
    }

}
