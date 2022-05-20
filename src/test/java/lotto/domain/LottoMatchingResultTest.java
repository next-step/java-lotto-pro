package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchingResultTest {

    @DisplayName("6개가 맞았을 경우 1등 확인")
    @Test
    void convertToLottoRankFirst() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(6, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개가 맞았을 경우 3등 확인")
    @Test
    void convertToLottoRankThird() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(5, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개가 맞았을 경우 4등 확인")
    @Test
    void convertToLottoRankFourth() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(4, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("3개가 맞았을 경우 5등 확인")
    @Test
    void convertToLottoRankFifth() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(3, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개가 맞았을 경우 꽝 확인")
    @Test
    void convertToLottoRankMiss_two() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(2, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.MISS);
    }

    @DisplayName("1개가 맞았을 경우 꽝 확인")
    @Test
    void convertToLottoRankMiss_one() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(1, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.MISS);
    }

    @DisplayName("0개가 맞았을 경우 꽝 확인")
    @Test
    void convertToLottoRankMiss_zero() {
        LottoMatchingResult matchingResult = new LottoMatchingResult(0, false);
        assertThat(matchingResult.convertToLottoRank()).isEqualTo(LottoRank.MISS);
    }

}
