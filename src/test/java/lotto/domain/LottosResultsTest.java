package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosResultsTest {

    @DisplayName("1등 카운트 2번 증가 후 결과 확인")
    @Test
    void getRankCountFirst() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.FIRST, 2);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.getRankCount(LottoRank.FIRST)).isEqualTo(2);
    }

    @DisplayName("3등 카운트 3번 증가 후 결과 확인")
    @Test
    void getRankCountThird() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.THIRD, 3);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.getRankCount(LottoRank.THIRD)).isEqualTo(3);
    }

    @DisplayName("4등 카운트 1번 증가 후 결과 확인")
    @Test
    void getRankCountFourth() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.FOURTH, 1);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.getRankCount(LottoRank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("꽝 카운트 2번 증가 후 결과 확인")
    @Test
    void getRankCountMiss() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.MISS, 2);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.getRankCount(LottoRank.MISS)).isEqualTo(2);
    }

    @DisplayName("여러 등수의 카운트 증가 후 결과 확인")
    @Test
    void getRankCountMulti() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.FIRST, 1);
        map.put(LottoRank.FOURTH, 2);
        map.put(LottoRank.MISS, 1);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottosResults.getRankCount(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lottosResults.getRankCount(LottoRank.MISS)).isEqualTo(1);
    }

    @DisplayName("여러 등수의 카운트 증가 후 총 금액 확인")
    @Test
    void calculateTotalMoney() {
        Map<LottoRank, Integer> map = new HashMap<>();
        map.put(LottoRank.FIRST, 1);
        map.put(LottoRank.FOURTH, 2);
        map.put(LottoRank.MISS, 1);

        LottosResults lottosResults = new LottosResults(map);

        assertThat(lottosResults.calculateTotalMoney()).isEqualTo(2000100000);
    }

}
