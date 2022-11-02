package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, 5000, (count, bonus) -> count == 3),
    NOTHING(0, 0, (count, bonus) -> count < 3);

    private final int count;
    private final int winnings;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int count, int winnings,
        BiPredicate<Integer, Boolean> isMatch) {
        this.count = count;
        this.winnings = winnings;
        this.isMatch = isMatch;
    }

    public static Rank valueOf(int count, boolean bonus) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
            .filter(r -> r.isMatch.test(count,bonus))
            .findAny();
        return rank.orElse(NOTHING);
    }

    public int matchedCount() {
        return count;
    }

    public int winnings() {
        return winnings;
    }

    public static List<Rank> valuesTheLowestOrder() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

}