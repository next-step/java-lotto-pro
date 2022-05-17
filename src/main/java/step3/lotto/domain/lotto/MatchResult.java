package step3.lotto.domain.lotto;

/**
 * @author : choi-ys
 * @date : 2022/05/17 1:42 오후
 */
public enum MatchResult {
    FIRST_PLACE("6개 일치", 2000000000),
    SECOND_PLACE("5개 일치", 1500000),
    THIRD_PLACE("4개 일치", 50000),
    FORTH_PLACE("3개 일치", 5000),
    NOTHING("당첨 사항 없음", 0);

    private final String statusDescription;
    private final int rewardPrice;

    MatchResult(String statusDescription, int rewardPrice) {
        this.statusDescription = statusDescription;
        this.rewardPrice = rewardPrice;
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

