import java.util.Arrays;

public enum LottoReward {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THREE(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int reward;

    LottoReward(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoReward valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(reward -> reward.isMatch(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatch(int countOfMatch, boolean matchBonus){
        if(this.matchCount != countOfMatch){
            return false;
        }
        if(this.equals(LottoReward.SECOND)){
            return matchBonus;
        }
        return true;
    }
}
