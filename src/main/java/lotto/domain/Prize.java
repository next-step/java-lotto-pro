package lotto.domain;

import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public enum Prize {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FAIL(0, 0);

    private static final Map<Integer, Prize> prizeMap = new ConcurrentHashMap<>();

    static {
        Arrays.stream(values()).forEach(v -> prizeMap.put(v.matchCount, v));
    }

    private final int matchCount;
    private final long prize;

    Prize(final int matchCount, final long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Winners matchLotto(final List<Lotto> lottoes, final Lotto winnigNumber) {
        return new Winners(lottoes.stream()
                .map(v -> v.matchCount(winnigNumber))
                .map(Prize::createPrize)
                .collect(Collectors.toList()));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    private static Prize createPrize(final long count) {
        return prizeMap.getOrDefault(Long.valueOf(count).intValue(), FAIL);
    }

}
