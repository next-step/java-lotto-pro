package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @DisplayName("1등 카운트 2번 증가 후 결과 확인")
    @Test
    void increaseAndGetFirst() {
        LottoResults lottoResults = new LottoResults();

        lottoResults.increaseRankCount(LottoRank.FIRST);
        lottoResults.increaseRankCount(LottoRank.FIRST);

        assertThat(lottoResults.getRankCount(LottoRank.FIRST)).isEqualTo(2);
    }

    @DisplayName("3등 카운트 3번 증가 후 결과 확인")
    @Test
    void increaseAndGetThird() {
        LottoResults lottoResults = new LottoResults();

        lottoResults.increaseRankCount(LottoRank.THIRD);
        lottoResults.increaseRankCount(LottoRank.THIRD);
        lottoResults.increaseRankCount(LottoRank.THIRD);

        assertThat(lottoResults.getRankCount(LottoRank.THIRD)).isEqualTo(3);
    }

    @DisplayName("4등 카운트 1번 증가 후 결과 확인")
    @Test
    void increaseAndGetFourth() {
        LottoResults lottoResults = new LottoResults();

        lottoResults.increaseRankCount(LottoRank.FOURTH);

        assertThat(lottoResults.getRankCount(LottoRank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("꽝 카운트 2번 증가 후 결과 확인")
    @Test
    void increaseAndGetMiss() {
        LottoResults lottoResults = new LottoResults();
        
        lottoResults.increaseRankCount(LottoRank.MISS);
        lottoResults.increaseRankCount(LottoRank.MISS);

        assertThat(lottoResults.getRankCount(LottoRank.MISS)).isEqualTo(2);
    }

    @DisplayName("여러 등수의 카운트 증가 후 결과 확인")
    @Test
    void increaseAndGetMulti() {
        LottoResults lottoResults = new LottoResults();

        lottoResults.increaseRankCount(LottoRank.FIRST);
        lottoResults.increaseRankCount(LottoRank.FOURTH);
        lottoResults.increaseRankCount(LottoRank.FOURTH);
        lottoResults.increaseRankCount(LottoRank.MISS);

        assertThat(lottoResults.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lottoResults.getRankCount(LottoRank.MISS)).isEqualTo(1);
    }

}