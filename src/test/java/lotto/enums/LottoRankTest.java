package lotto.enums;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("6개가 맞았을 경우 1등 확인")
    @Test
    void findMatchedLottoRankFirst() {
        assertThat(LottoRank.findMatchedLottoRank(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개가 맞고 보너스도 매치된 경우 2등 확인")
    @Test
    void findMatchedLottoRankSecond() {
        assertThat(LottoRank.findMatchedLottoRank(5, true)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개가 맞았을 경우 3등 확인")
    @Test
    void findMatchedLottoRankThird() {
        assertThat(LottoRank.findMatchedLottoRank(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개가 맞았을 경우 4등 확인")
    @Test
    void findMatchedLottoRankFourth() {
        assertThat(LottoRank.findMatchedLottoRank(4, false)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("3개가 맞았을 경우 5등 확인")
    @Test
    void findMatchedLottoRankFifth() {
        assertThat(LottoRank.findMatchedLottoRank(3, false)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개가 맞았을 경우 꽝 확인")
    @Test
    void findMatchedLottoRankMiss_two() {
        assertThat(LottoRank.findMatchedLottoRank(2, false)).isEqualTo(LottoRank.MISS);
    }

    @DisplayName("1개가 맞았을 경우 꽝 확인")
    @Test
    void findMatchedLottoRankMiss_one() {
        assertThat(LottoRank.findMatchedLottoRank(1, false)).isEqualTo(LottoRank.MISS);
    }

    @DisplayName("0개가 맞았을 경우 꽝 확인")
    @Test
    void findMatchedLottoRankMiss_zero() {
        assertThat(LottoRank.findMatchedLottoRank(0, false)).isEqualTo(LottoRank.MISS);
    }
}