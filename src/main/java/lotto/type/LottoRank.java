package lotto.type;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);
    private final int matchedCount;
    private final int price;
    private final boolean isBonusBallCheck;

    LottoRank(int matchedCount, int price, boolean isBonusBallCheck) {
        this.matchedCount = matchedCount;
        this.price = price;
        this.isBonusBallCheck = isBonusBallCheck;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoRank findLottoRankByMatchedCount(int matchedCount, boolean isMatchedBonusBall) {
        BiPredicate<Integer, Boolean> lottoRankBiPredicate = (count, isCheck) -> count == matchedCount && isCheck == isMatchedBonusBall;

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRankBiPredicate.test(lottoRank.getMatchedCount(), lottoRank.isBonusBallCheck))
                .findFirst()
                .orElse(NONE);
    }
}
