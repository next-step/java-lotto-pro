package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST_PLACE(6, 2_000_000_000, false),
    BONUS_PLACE(5, 30_000_000, true),
    SECOND_PLACE(5, 1_500_000, false),
    THIRD_PLACE(4, 50_000, false),
    FOURTH_PLACE(3, 5_000, false),
    FAIL(0, 0, false);

    private final int matchCount;
    private final long prize;
    private final boolean bonus;

    Prize(final int matchCount, final long prize, final boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Prize matchLotto(final Lotto lotto, final WinningNumbers winningNumbers) {
        final long count = lotto.matchCount(winningNumbers.getWinner());
        final boolean bonus = lotto.contains(winningNumbers.getBonusNumber());
        return createPrize(count, bonus);
    }

    private static Prize createPrize(final long count, final boolean bonus) {
        return Arrays.stream(values())
                .filter(prize -> matchPrize(prize, count, bonus))
                .findAny()
                .orElse(Prize.FAIL);
    }

    private static boolean matchPrize(final Prize prize, final long count, final boolean bonus) {
        return (prize.matchCount == count) && (prize.bonus == isBonus(count, bonus));
    }

    private static boolean isBonus(final long count, final boolean bonus) {
        return (count == Prize.SECOND_PLACE.matchCount) && bonus;
    }
}
