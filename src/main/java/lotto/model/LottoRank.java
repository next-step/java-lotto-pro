package lotto.model;

import static lotto.constants.LottoErrorMessage.OUT_OF_RANGE_LOTTO_RANK;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    private final int hits;
    private final int cashPrize;

    LottoRank(int hits, int cashPrize) {
        this.hits = hits;
        this.cashPrize = cashPrize;
    }

    public int getHits() {
        return hits;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public static LottoRank findByHits(int hits) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.hits == hits)
                .findAny()
                .orElseThrow(() -> new IllegalStateException(OUT_OF_RANGE_LOTTO_RANK));
    }
}
