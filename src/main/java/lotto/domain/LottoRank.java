package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank implements Comparator<LottoRank> {
    FIRST(6, 2_000_000_000, 1),
    SECOND(5, 30_000_000, 2),
    THIRD(5, 1_500_000, 3),
    FOURTH(4, 50_000, 4),
    FIFTH(3, 5_000, 5),
    FAIL(0, 0, 6);

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

    public static LottoRank reword(int matchCount, boolean bonusContain) {
        if (matchCount == LottoRank.SECOND.matchCount && bonusContain) {
            return LottoRank.SECOND;
        }
        return Arrays.stream(LottoRank.values())
                .filter((LottoRank.SECOND::notEquals))
                .filter((lottoRank -> sameMatchCount(matchCount, lottoRank)))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    public static List<LottoRank> winnerRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !lottoRank.equals(LottoRank.FAIL))
                .collect(Collectors.toList());
    }

    private boolean notEquals(LottoRank lottoRank) {
        return !this.equals(lottoRank);
    }

    @Override
    public int compare(LottoRank o1, LottoRank o2) {
        return Integer.compare(o1.order, o2.order);
    }

    private static boolean sameMatchCount(int matchCount, LottoRank lottoRank) {
        return lottoRank.matchCount == matchCount;
    }

}
