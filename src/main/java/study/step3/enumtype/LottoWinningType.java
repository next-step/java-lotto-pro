package study.step3.enumtype;

public enum LottoWinningType {
    MATCH_COUNT_6(6, 2000000000),
    MATCH_COUNT_5(5, 1500000),
    MATCH_COUNT_4(4, 50000),
    MATCH_COUNT_3(3, 5000),
    MATCH_COUNT_2(2, 0),
    MATCH_COUNT_1(1, 0),
    MATCH_COUNT_0(0, 0),
    ;

    private final int matchCount;
    private final int winnings;

    LottoWinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }

    public static LottoWinningType valueOf(int matchCount) {
        if (matchCount == MATCH_COUNT_6.matchCount) {
            return MATCH_COUNT_6;
        }
        if (matchCount == MATCH_COUNT_5.matchCount) {
            return MATCH_COUNT_5;
        }
        if (matchCount == MATCH_COUNT_4.matchCount) {
            return MATCH_COUNT_4;
        }
        if (matchCount == MATCH_COUNT_3.matchCount) {
            return MATCH_COUNT_3;
        }
        if (matchCount == MATCH_COUNT_2.matchCount) {
            return MATCH_COUNT_2;
        }
        if (matchCount == MATCH_COUNT_1.matchCount) {
            return MATCH_COUNT_1;
        }
        if (matchCount == MATCH_COUNT_0.matchCount) {
            return MATCH_COUNT_0;
        }

        throw new IllegalArgumentException("");
    }
}
