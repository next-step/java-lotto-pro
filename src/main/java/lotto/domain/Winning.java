package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Winning {

    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matches;
    private final int reward;

    Winning(int matches, int reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public int getMatches() {
        return matches;
    }

    public int getReward() {
        return reward;
    }

    public static double getRewardsByMatch(int matches) {

        double rewards = 0;

        for (Winning winning : getWinningInfo()) {
            rewards += getRewards(winning, matches);
        }

        return rewards;
    }

    private static double getRewards(Winning winning, int matches) {
        if (winning.getMatches() == matches) {
            return winning.getReward();
        }
        return 0;
    }

    public static List<Winning> getWinningInfo() {
        return Arrays.asList(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES);
    }

}
