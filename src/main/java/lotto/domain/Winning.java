package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Winning {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

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

    private static Winning getWinningByMatch(int matches) {
        return getWinningInfo().stream()
                .filter(winning -> winning.getMatches() == matches && winning != SECOND)
                .findFirst()
                .orElse(MISS);
    }

    public static Winning valueOf(int matches, boolean matchBonus) {
        if (matches == SECOND.getMatches() && matchBonus) {
            return SECOND;
        }
        return Winning.getWinningByMatch(matches);
    }

    public static List<Winning> getWinningInfo() {
        return Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }
}
