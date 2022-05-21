package study.lotto.enumtype;

import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    private final int matchCount;
    private final int winnings;

    LottoRank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoRank valueOf(int matchCount) {
        return Stream.of(values())
                .filter(lottoWinningType -> lottoWinningType.getMatchCount() == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}
