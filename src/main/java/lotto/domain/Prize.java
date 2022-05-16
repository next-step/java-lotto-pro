package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(1_500_000),
    THIRD_PLACE(50_000),
    FORTH_PLACE(5_000),
    FAIL(0);

    private static final Prize[] prizes = {FAIL, FAIL, FAIL, FORTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE};
    private final int prize;

    public int getPrize() {
        return prize;
    }

    Prize(final int prize) {
        this.prize = prize;
    }

    public static List<Prize> matchLotto(final List<Lotto> lottoes, final Lotto answer) {
        return lottoes.stream()
                .map(v -> v.matchCount(answer))
                .map(Prize::createPrize)
                .collect(Collectors.toList());
    }

    private static Prize createPrize(final long count) {
        return prizes[Long.valueOf(count).intValue()];
    }
}
