package step3.lotto.domain.lotto;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:42 오후
 */
public enum MatchResult {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FORTH_PLACE(3, 5000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int rewardPrice;

    MatchResult(int matchCount, int rewardPrice) {
        this.matchCount = matchCount;
        this.rewardPrice = rewardPrice;
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
}
