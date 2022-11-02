package lotto;

import java.util.Arrays;

// TODO : remove
public enum LottoRank {

    FIRST(LottoNumberMatchCount.ALL),
    SECOND(LottoNumberMatchCount.FIVE),
    THIRD(LottoNumberMatchCount.FOUR),
    FOURTH(LottoNumberMatchCount.THREE),
    NOTHING(LottoNumberMatchCount.NOTHING);

    private final LottoNumberMatchCount matchCount;

    LottoRank(final LottoNumberMatchCount matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoRank fromMatchCount(final LottoNumberMatchCount matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount.equals(matchCount))
            .findFirst()
            .orElse(LottoRank.NOTHING);
    }

}
