package lotto.enums;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public enum LottoRankType {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(-1,0);

    private int matchedCount;
    private int price;

    LottoRankType(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static LottoRankType matchRankType(Lotto lotto, Lotto winningLotto) {
        int matchedCount = lotto.countMatchedNumbers(winningLotto);
        return rankTypeByMatchedCount(matchedCount);
    }

    private static LottoRankType rankTypeByMatchedCount(int matchedCount) {
        if(matchedCount == 6)
            return FIRST;
        if(matchedCount == 5)
            return SECOND;
        if(matchedCount == 4)
            return THIRD;
        if(matchedCount == 3)
            return FOURTH;
        return LOSE;
    }

    public static List<LottoRankType> rankListWithReverseOrder() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}
