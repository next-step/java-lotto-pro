package lotto.domain;

import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FAIL(0, 0);

    private static final Prize[] prizes = {FAIL, FAIL, FAIL, FOURTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE};
    private final long prize;
    private final int matchCount;

    Prize(final int matchCount, final long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Winners matchLotto(final List<Lotto> lottoes, final Lotto answer) {
        return new Winners(lottoes.stream()
                .map(v -> v.matchCount(answer))
                .map(Prize::createPrize)
                .collect(Collectors.toList()));
    }

    private static Prize createPrize(final long count) {
        return prizes[Long.valueOf(count).intValue()];
    }

    public long calculatePrize(final long count) {
        return prize * count;
    }

    public void printMatch(final long count) {
        ResultView.resultLotto(matchCount, prize, count);
    }
}
