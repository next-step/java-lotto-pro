package lotto.domain;

import java.util.Arrays;
import lotto.WinningLotto;

public enum LottoRanking {
    MISS(0, false, 0),
    FIFTH_PRIZE(3, false, 5_000),
    FOURTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 3_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000);

    private int matchingNumber;
    private boolean hasBonusNumber;
    private int winAmount;

    LottoRanking(int matchingNumber, boolean hasBonusNumber, int winAmount) {
        this.matchingNumber = matchingNumber;
        this.hasBonusNumber = hasBonusNumber;
        this.winAmount = winAmount;
    }

    public static LottoRanking findLottoRaking(Lotto lotto, WinningLotto winningLotto) {
        int matchingNumber = winningLotto.matchNumberCount(lotto);
        boolean hasBounusNumber = winningLotto.hasBonusNumber(lotto);

        return Arrays.stream(LottoRanking.values())
            .filter(lottoRanking -> lottoRanking.matchingNumber == matchingNumber)
            .filter(lottoRanking -> lottoRanking.hasBonusNumber == hasBounusNumber)
            .findFirst().orElse(LottoRanking.MISS);
    }

    public int getWinAmount() {
        return winAmount;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }
}