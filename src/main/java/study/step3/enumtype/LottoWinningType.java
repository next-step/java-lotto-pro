package study.step3.enumtype;

import java.util.stream.Stream;

public enum LottoWinningType {
    MATCH_COUNT_6(6, 2000000000),
    MATCH_COUNT_5(5, 1500000),
    MATCH_COUNT_4(4, 50000),
    MATCH_COUNT_3(3, 5000),
    MATCH_NOT_COUNT(0, 0),
    ;

    private final int matchCount;
    private final int winnings;

    LottoWinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoWinningType valueOf(int matchCount) {
        return Stream.of(values())
                .filter(lottoWinningType -> lottoWinningType.getMatchCount() == matchCount)
                .findFirst()
                .orElse(MATCH_NOT_COUNT);
    }
}
