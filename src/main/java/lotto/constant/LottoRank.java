package lotto.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    SECOND_BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchNumberCount;
    private final int winningAmount;
    private static final Map<Integer, LottoRank> matchCountRankExcludeBonus = Collections
            .unmodifiableMap(Arrays.stream(values()).filter(lottoRank -> !SECOND_BONUS.equals(lottoRank))
                    .collect(Collectors.toMap(LottoRank::getMatchNumberCount, Function.identity())));

    LottoRank(int matchNumberCount, int winningAmount) {
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRank of(int matchNumberCount, boolean isBonusMatch) {
        LottoRank lottoRank = matchCountRankExcludeBonus.getOrDefault(matchNumberCount, NONE);
        if (SECOND.equals(lottoRank) && isBonusMatch) {
            return SECOND_BONUS;
        }
        return lottoRank;
    }

    public static Set<LottoRank> valuesExcludeNone() {
        return EnumSet.of(FIRST, SECOND_BONUS, SECOND, THIRD, FOURTH);
    }
}
