package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

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
        return Stream.of(FIRST, SECOND, THIRD, FOURTH)
                .sorted(Comparator.comparing(Rank::getCountOfMatch))
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter( rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}
