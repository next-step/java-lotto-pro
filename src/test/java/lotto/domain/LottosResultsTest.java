package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosResultsTest {

    @DisplayName("1등 카운트 2번 증가 후 결과 확인")
    @Test
    void increaseAndGetFirst() {
        LottosResults lottosResults = new LottosResults();

        lottosResults.increaseRankCount(LottoRank.FIRST);
        lottosResults.increaseRankCount(LottoRank.FIRST);

        assertThat(lottosResults.getRankCount(LottoRank.FIRST)).isEqualTo(2);
    }

    @DisplayName("3등 카운트 3번 증가 후 결과 확인")
    @Test
    void increaseAndGetThird() {
        LottosResults lottosResults = new LottosResults();

        lottosResults.increaseRankCount(LottoRank.THIRD);
        lottosResults.increaseRankCount(LottoRank.THIRD);
        lottosResults.increaseRankCount(LottoRank.THIRD);

        assertThat(lottosResults.getRankCount(LottoRank.THIRD)).isEqualTo(3);
    }

    @DisplayName("4등 카운트 1번 증가 후 결과 확인")
    @Test
    void increaseAndGetFourth() {
        LottosResults lottosResults = new LottosResults();

        lottosResults.increaseRankCount(LottoRank.FOURTH);

        assertThat(lottosResults.getRankCount(LottoRank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("꽝 카운트 2번 증가 후 결과 확인")
    @Test
    void increaseAndGetMiss() {
        LottosResults lottosResults = new LottosResults();
        
        lottosResults.increaseRankCount(LottoRank.MISS);
        lottosResults.increaseRankCount(LottoRank.MISS);

        assertThat(lottosResults.getRankCount(LottoRank.MISS)).isEqualTo(2);
    }

    @DisplayName("여러 등수의 카운트 증가 후 결과 확인")
    @Test
    void increaseAndGetMulti() {
        LottosResults lottosResults = new LottosResults();

        lottosResults.increaseRankCount(LottoRank.FIRST);
        lottosResults.increaseRankCount(LottoRank.FOURTH);
        lottosResults.increaseRankCount(LottoRank.FOURTH);
        lottosResults.increaseRankCount(LottoRank.MISS);

        assertThat(lottosResults.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottosResults.getRankCount(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lottosResults.getRankCount(LottoRank.MISS)).isEqualTo(1);
    }

    @DisplayName("여러 등수의 카운트 증가 후 총 금액 확인")
    @Test
    void calculateTotalMoney() {
        LottosResults lottosResults = new LottosResults();

        lottosResults.increaseRankCount(LottoRank.FIRST);
        lottosResults.increaseRankCount(LottoRank.FOURTH);
        lottosResults.increaseRankCount(LottoRank.FOURTH);
        lottosResults.increaseRankCount(LottoRank.MISS);

        assertThat(lottosResults.calculateTotalMoney()).isEqualTo(2000100000);
    }

}
