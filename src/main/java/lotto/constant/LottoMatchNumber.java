package lotto.constant;

import java.util.EnumSet;

public enum LottoMatchNumber {

     MATCH3(3,5_000)
    ,MATCH4(4,10_000)
    ,MATCH5(5,1_500_000)
    ,MATCH6(6,2_000_000_000);

    private final int matchNumberCount;
    private final int winningAmount;

    private static final EnumSet<LottoMatchNumber> matchNumbers = EnumSet.allOf(LottoMatchNumber.class);

    LottoMatchNumber(int matchNumberCount, int winningAmount) {
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
    }

    public static EnumSet<LottoMatchNumber> allMatchNumber(){
        return matchNumbers;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
