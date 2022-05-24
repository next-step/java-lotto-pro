package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("일치하는 숫자에 따른 등수를 반환한다.")
    @Test
    void 로또_일치하는개수_등수_테스트() {
        assertAll(
            () -> assertEquals(LottoRank.findMatch(6, true), LottoRank.FIRST),
            () -> assertEquals(LottoRank.findMatch(6, false), LottoRank.FIRST),
            () -> assertEquals(LottoRank.findMatch(5, true), LottoRank.SECOND),
            () -> assertEquals(LottoRank.findMatch(5, false), LottoRank.THIRD),
            () -> assertEquals(LottoRank.findMatch(4, true), LottoRank.FOURTH),
            () -> assertEquals(LottoRank.findMatch(4, false), LottoRank.FOURTH),
            () -> assertEquals(LottoRank.findMatch(3, true), LottoRank.FIFTH),
            () -> assertEquals(LottoRank.findMatch(3, false), LottoRank.FIFTH),
            () -> assertEquals(LottoRank.findMatch(2, true), LottoRank.LOSE),
            () -> assertEquals(LottoRank.findMatch(2, false), LottoRank.LOSE),
            () -> assertEquals(LottoRank.findMatch(1, true), LottoRank.LOSE),
            () -> assertEquals(LottoRank.findMatch(1, false), LottoRank.LOSE),
            () -> assertEquals(LottoRank.findMatch(0, true), LottoRank.LOSE),
            () -> assertEquals(LottoRank.findMatch(0, false), LottoRank.LOSE)
        );
    }

    @Test
    @DisplayName("등수에 따라 맞는 로또번호 일치개수를 반환한다.")
    void 로또_일치하는개수_등수_반환_테스트() {
        assertAll(
            () -> assertEquals(LottoRank.FIRST.getMatchCount(), 6),
            () -> assertEquals(LottoRank.SECOND.getMatchCount(), 5),
            () -> assertEquals(LottoRank.THIRD.getMatchCount(), 5),
            () -> assertEquals(LottoRank.FOURTH.getMatchCount(), 4),
            () -> assertEquals(LottoRank.FIFTH.getMatchCount(), 3),
            () -> assertEquals(LottoRank.LOSE.getMatchCount(), 0)
        );
    }

    @Test
    @DisplayName("등수에 따라 맞는 금액을 반환한다.")
    void 로또_일치하는개수_금액_반환_테스트() {
        assertAll(
            () -> assertEquals(LottoRank.FIRST.getPrize(), 2_000_000_000),
            () -> assertEquals(LottoRank.SECOND.getPrize(), 30_000_000),
            () -> assertEquals(LottoRank.THIRD.getPrize(), 1_500_000),
            () -> assertEquals(LottoRank.FOURTH.getPrize(), 50_000),
            () -> assertEquals(LottoRank.FIFTH.getPrize(), 5_000),
            () -> assertEquals(LottoRank.LOSE.getPrize(), 0)
        );
    }

}