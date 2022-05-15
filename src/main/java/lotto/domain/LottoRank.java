package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank implements Comparator<LottoRank> {
    FIRST(6, 2_000_000_000, 1),
    SECOND(5, 1_500_000, 2),
    THIRD(4, 50_000, 3),
    FOURTH(3, 5_000, 4),
    FAIL(0, 0, 5);

    private final int matchCount;
    private final int money;
    private final int order;

    LottoRank(int matchCount, int money, int order) {
        this.matchCount = matchCount;
        this.money = money;
        this.order = order;
    }

    public int rewordMoney() {
        return this.money;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static LottoRank reword(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter((lottoRank -> sameMatchCount(matchCount, lottoRank)))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    public static List<LottoRank> winnerRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.FAIL))
                .collect(Collectors.toList());
    }

    @Override
    public int compare(LottoRank o1, LottoRank o2) {
        return Integer.compare(o1.order, o2.order);
    }

    private static boolean sameMatchCount(int matchCount, LottoRank lottoRank) {
        return lottoRank.matchCount == matchCount;
    }

}
