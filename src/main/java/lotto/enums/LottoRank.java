package lotto.enums;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(6, 2_000_000_000, (count, bonusMatch) -> count == 6),
    SECOND(5, 30_000_000, (count, bonusMatch) -> count == 5 && bonusMatch),
    THIRD(5, 1_500_000, (count, bonusMatch) -> count == 5 && !bonusMatch),
    FOURTH(4, 50_000, (count, bonusMatch) -> count == 4),
    FIFTH(3, 5_000, (count, bonusMatch) -> count == 3),
    MISS(0, 0, (count, bonusMatch) -> count < 3 && count >= 0);

    private static final String ERROR_MESSAGE_COUNT_OF_MATCH_OUT_OF_RANGE = "[ERROR] countOfMatch is out of range.";

    private final int countOfMatch;
    private final int winningMoney;
    private final BiPredicate<Integer, Boolean> matchingBiPredicate;

    LottoRank(int countOfMatch, int winningMoney, BiPredicate<Integer, Boolean> matchingBiPredicate) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchingBiPredicate = matchingBiPredicate;
    }

    public static LottoRank findMatchedLottoRank(int countOfMatch, boolean isBonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingBiPredicate.test(countOfMatch, isBonusMatched))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_COUNT_OF_MATCH_OUT_OF_RANGE));
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
