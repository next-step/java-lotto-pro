package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStatisticsTest {
    @DisplayName("로또 결과 통계 생성 후 당첨 갯수 비교 테스트")
    @ParameterizedTest(name = "로또 결과 {0} {1}개 통계 생성 후 {2}의 당첨 갯수 {3} 비교 테스트")
    @CsvSource({"FIRST, 1, FIRST, 1", "THIRD, 2, THIRD, 2", "THIRD, 10, MISS, 0", "MISS, 0, MISS, 0",
            "MISS, 5, MISS, 5", "FIFTH, 3, MISS, 0"})
    void lottoStatisticsCount(LottoRanking lottoRanking, int count, LottoRanking input, int expect) {
        Map<LottoRanking, Integer> map = new EnumMap<>(LottoRanking.class);
        map.put(lottoRanking, count);
        LottoStatistics lottoStatistics = new LottoStatistics(map);
        assertThat(lottoStatistics.get(input)).isEqualTo(expect);
    }

    @DisplayName("로또 결과 통계 생성 후 당첨 갯수 비교 테스트")
    @ParameterizedTest(name = "로또 결과 {0} {1}개 통계 생성 후 {2}의 당첨 갯수 {3} 비교 테스트")
    @CsvSource({"1000, 1510.00", "20000000, 0.07", "10000000, 0.15"})
    void lottoStatisticsCount(int input, BigDecimal expect) {
        Map<LottoRanking, Integer> map = new EnumMap<>(LottoRanking.class);
        map.put(LottoRanking.FIFTH, 2);
        map.put(LottoRanking.THIRD, 1);
        LottoStatistics lottoStatistics = new LottoStatistics(map);
        assertThat(lottoStatistics.yield(Money.from(input))).isEqualTo(expect);
    }
}
