package step3.lotto.domain.lotto;

import java.util.Arrays;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:42 오후
 */
public enum MatchResult {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 3_000_000),
    THIRD_PLACE(5, 1_500_000),
    FORTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int rewardPrice;

    MatchResult(int matchCount, int rewardPrice) {
        this.matchCount = matchCount;
        this.rewardPrice = rewardPrice;
    }

    public static MatchResult valueOf(int matchCount, boolean matchBonus) {
        if (isLittleThanFifthPlaceCount(matchCount)) {
            return MatchResult.NOTHING;
        }

        if (isSecondPlaceCandidate(matchCount)) {
            return choiceSecondPlaceOrThirdPlace(matchBonus);
        }

        return Arrays.stream(MatchResult.values())
            .filter(matchResult -> matchResult.isMatchCount(matchCount))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatchCount(int countOfMatch) {
        return this.matchCount == countOfMatch;
    }

    private static MatchResult choiceSecondPlaceOrThirdPlace(boolean matchBonus) {
        if (matchBonus) {
            return MatchResult.SECOND_PLACE;
        }
        return MatchResult.THIRD_PLACE;
    }

    private static boolean isSecondPlaceCandidate(int countOfMatch) {
        return countOfMatch == SECOND_PLACE.getMatchCount();
    }

    private static boolean isLittleThanFifthPlaceCount(int countOfMatch) {
        return countOfMatch < FIFTH_PLACE.getMatchCount();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }

    public boolean isFirstPlace() {
        return this == FIRST_PLACE;
    }

    public boolean isSecondPlace() {
        return this == SECOND_PLACE;
    }

    public boolean isThirdPlace() {
        return this == THIRD_PLACE;
    }

    public boolean isForthPlace() {
        return this == FORTH_PLACE;
    }

    public boolean isFifthPlace() {
        return this == FIFTH_PLACE;
    }
}
