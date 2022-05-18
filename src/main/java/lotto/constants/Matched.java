package lotto.constants;

public enum Matched {
    NOT_MATCHED(0, 0),
    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    FIVE_AND_BONUS_MATCHED(5, 30_000_000),
    SIX_MATCHED(6, 2_000_000_000);

    private final int count;
    private final int reward;

    Matched(final int count, final int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }

    public static Matched getByCountAndBonusMatched(final int count, final boolean bonusMatched) {
        if(THREE_MATCHED.count == count) {
            return THREE_MATCHED;
        }
        if(FOUR_MATCHED.count == count) {
            return FOUR_MATCHED;
        }
        if(FIVE_MATCHED.count == count && !bonusMatched) {
            return FIVE_MATCHED;
        }
        if(FIVE_MATCHED.count == count && bonusMatched) {
            return FIVE_AND_BONUS_MATCHED;
        }
        if(SIX_MATCHED.count == count) {
            return SIX_MATCHED;
        }
        return NOT_MATCHED;
    }
}
