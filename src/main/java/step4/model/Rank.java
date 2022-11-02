package step4.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == 6),
    SECOND(5, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
    THIRD(5, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
    FOURTH(4, 50_000, (countOfMatch, matchBonus) -> countOfMatch == 4),
    FIFTH(3, 5_000, (countOfMatch, matchBonus) -> countOfMatch == 3),
    MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch < 3);

    private final int countOfMatch;
    private final int winningMoney;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int countOfMatch, int winningMoney, BiPredicate<Integer, Boolean> isMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isMatch = isMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch.test(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public double getProfitTotalMoney(int count) {
        return count * this.winningMoney;
    }
}
