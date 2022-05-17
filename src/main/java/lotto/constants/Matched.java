package lotto.constants;

public enum Matched {
    NOT_MATCHED(0),
    THREE_MATCHED(5_000),
    FOUR_MATCHED(50_000),
    FIVE_MATCHED(1_500_000),
    FIVE_AND_BONUS_MATCHED(30_000_000),
    SIX_MATCHED(2_000_000_000);

    private static int THREE_MATCHED_COUNT = 3;
    private static int FOUR_MATCHED_COUNT = 4;
    private static int FIVE_MATCHED_COUNT = 5;
    private static int SIX_MATCHED_COUNT = 6;

    private final int reward;

    Matched(final int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }

    public static Matched getByCountAndBonusMatched(final int count, final boolean bonusMatched) {
        if(THREE_MATCHED_COUNT == count) {
            return THREE_MATCHED;
        }
        if(FOUR_MATCHED_COUNT == count) {
            return FOUR_MATCHED;
        }
        if(FIVE_MATCHED_COUNT == count && !bonusMatched) {
            return FIVE_MATCHED;
        }
        if(FIVE_MATCHED_COUNT == count && bonusMatched) {
            return FIVE_AND_BONUS_MATCHED;
        }
        if(SIX_MATCHED_COUNT == count) {
            return SIX_MATCHED;
        }
        return NOT_MATCHED;
    }
}
