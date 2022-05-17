package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(new Match(6), 2_000_000_000),
    SECOND(new Match(5), 30_000_000),
    THIRD(new Match(5), 1_500_000),
    FOURTH(new Match(4), 50_000),
    FIFTH(new Match(3), 5_000),
    MISS(new Match(0), 0);

    private final Match match;
    private final int prize;

    Rank(Match match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public Match getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(Match match, boolean matchBonus) {
        Rank[] ranks = values();
        if (match.equals(Rank.SECOND.match) && matchBonus) {
            return Rank.SECOND;
        }
        if (match.equals(Rank.THIRD.match)) {
            return Rank.THIRD;
        }
        return Arrays.stream(ranks)
                .filter(rank -> rank.match.equals(match))
                .findFirst()
                .orElse(Rank.MISS);
    }
}
