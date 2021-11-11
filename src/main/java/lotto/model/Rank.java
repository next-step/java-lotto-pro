package lotto.model;

import java.util.*;
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

    public static Map<Rank, Integer> createRanks() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        List<Rank> winningRanks = Rank.createWinningRanks();
        for (Rank winningRank : winningRanks) {
            result.put(winningRank, 0);
        }
        return result;
    }

    private static List<Rank> createWinningRanks() {
        return Stream.of(FIRST, SECOND, THIRD, FOURTH, FIFTH)
                .sorted(Comparator.comparing(Rank::getWinningMoney))
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return isSecondOrThird(matchBonus);
        }
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private static Rank isSecondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
