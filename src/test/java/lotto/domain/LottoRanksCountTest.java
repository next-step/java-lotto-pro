package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRanksCountTest {
    @DisplayName("rank 별로 count 된 숫자를 반환한다")
    @Test
    void getRankCount() {
        LottoRanksCount lottoRanksCount = new LottoRanksCount(Arrays.asList(
            Rank.FIRST,
            Rank.SECOND, Rank.SECOND,
            Rank.THIRD, Rank.THIRD, Rank.THIRD,
            Rank.FOURTH, Rank.FOURTH, Rank.FOURTH, Rank.FOURTH,
            Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.FIFTH,
            Rank.MISS
        ));
        assertEquals(1, lottoRanksCount.getRankCount(Rank.FIRST));
        assertEquals(2, lottoRanksCount.getRankCount(Rank.SECOND));
        assertEquals(3, lottoRanksCount.getRankCount(Rank.THIRD));
        assertEquals(4, lottoRanksCount.getRankCount(Rank.FOURTH));
        assertEquals(5, lottoRanksCount.getRankCount(Rank.FIFTH));
        assertEquals(1, lottoRanksCount.getRankCount(Rank.MISS));
    }

    @DisplayName("값이 없을 경우 0 을 리턴한다")
    @Test
    void getRankCountByEmptyList() {
        LottoRanksCount lottoRanksCount = new LottoRanksCount(Collections.emptyList());
        assertEquals(0, lottoRanksCount.getRankCount(Rank.FIRST));
        assertEquals(0, lottoRanksCount.getRankCount(Rank.SECOND));
        assertEquals(0, lottoRanksCount.getRankCount(Rank.THIRD));
        assertEquals(0, lottoRanksCount.getRankCount(Rank.FOURTH));
        assertEquals(0, lottoRanksCount.getRankCount(Rank.FIFTH));
        assertEquals(0, lottoRanksCount.getRankCount(Rank.MISS));
    }
}
