package lotto.enums;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoRank {

    FIRST(6, new BigDecimal(2_000_000_000)),
    SECOND(5, new BigDecimal(1_500_000)),
    THIRD(4, new BigDecimal(50_000)),
    FOURTH(3, new BigDecimal(5_000)),
    NONE(0, new BigDecimal(0)),
    ;

    private final int matchNumberCount;
    private final BigDecimal reward;

    LottoRank(int matchNumberCount, BigDecimal reward) {
        this.matchNumberCount = matchNumberCount;
        this.reward = reward;
    }

    public static LottoRank getRank(int matchNumberCount) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> item.matchNumberCount == matchNumberCount)
                .findFirst()
                .orElse(LottoRank.NONE);
    }

}