package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static List<Rank> createWinningRanks() {
        return Stream.of(FIRST, SECOND, THIRD, FOURTH, FIFTH)
                .sorted(Comparator.comparing(Rank::getCountOfMatch))
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == SECOND.countOfMatch && !matchBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}
