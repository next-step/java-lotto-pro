package lotto.domain;

public enum LottoReward {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    private final int matchCount;
    private final int rewardMoney;

    LottoReward(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static boolean isWinning(int matchCount) {
        for (LottoReward lottoReward : LottoReward.values()) {
            if (lottoReward.matchCount == matchCount) {
                return true;
            }
        }
        return false;
    }

    public static LottoReward getLottoReward(int matchCount) {
        for (LottoReward lottoReward : LottoReward.values()) {
            if (lottoReward.matchCount == matchCount) {
                return lottoReward;
            }
        }
        return null;
    }
}
