package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과들 테스트")
public class LottoResultsTest {
    private LottoResults lottoResults;

    @BeforeEach
    void setup() {
        List<LottoResult> lottoResultSources = Arrays.asList(new LottoResult(3), new LottoResult(6));
        lottoResults = new LottoResults(lottoResultSources);
    }

    @DisplayName("로또 결과들 중 6개 다 맞춘 순위의 개수 테스트")
    @Test
    void getLottoResults() {
        assertThat(lottoResults.getMatchAmount(6)).isEqualTo(1);
    }

    @DisplayName("로또 결과들 중 match3 1개, match6 1개 맞췄을 경우 합계 테스트")
    @Test
    void getTotalRewardTest() {
        assertThat(lottoResults.getTotalReward()).isEqualTo(2000005000);
    }

    @DisplayName("로또 결과들 중 match3 1개 맞췄을 경우 수익률 테스트")
    @Test
    void getProfitRateTest() {
        assertThat(lottoResults.getProfitRate(new BuyAmount(14000))).isEqualTo(142857.50);
    }
}
