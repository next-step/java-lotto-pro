package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND_BONUS(5, 30_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    DROP(0, 0);

    private final Integer count;
    private final Integer prize;

    Ranking(Integer count, Integer prize) {
        this.count = count;
        this.prize = prize;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPrize() {
        return prize;
    }

    public static Ranking find(int count, boolean hasBonusBall) {
        if (count == Ranking.SECOND_BONUS.getCount() && !hasBonusBall) {
            return Ranking.SECOND;
        }

        return Arrays.stream(values())
                .filter(value -> value.getCount().equals(count))
                .findFirst()
                .orElse(Ranking.DROP);
    }
}
