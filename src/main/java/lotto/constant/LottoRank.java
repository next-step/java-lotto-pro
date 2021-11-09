package lotto.constant;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    NONE(0, Constants.IGNORE_COUNT, 0),
    FIFTH(3, Constants.IGNORE_COUNT, 5000),
    FOURTH(4, Constants.IGNORE_COUNT, 5_0000),
    THIRD(5, 0, 150_0000),
    SECOND(5, 1, 3000_0000),
    FIRST(6, Constants.IGNORE_COUNT, 20_0000_0000);

    private final int matchingCount;
    private final int bonusMatchingCount;
    private final int price;

    LottoRank(int matchingCount, int bonusMatchingCount, int price) {
        this.matchingCount = matchingCount;
        this.bonusMatchingCount = bonusMatchingCount;
        this.price = price;
    }

    public static LottoRank findRank(int matchingCount, int bonusMatchingCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchingCount == matchingCount)
                .filter(checkBonusMatchingCount(bonusMatchingCount))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private static Predicate<LottoRank> checkBonusMatchingCount(int bonusMatchingCount) {
        return lottoRank -> {
            if (Constants.IGNORE_COUNT == lottoRank.bonusMatchingCount) {
                return true;
            }

            return lottoRank.bonusMatchingCount == bonusMatchingCount;
        };
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrice() {
        return price;
    }

    private static class Constants {
        public static final int IGNORE_COUNT = -1;
    }
}
