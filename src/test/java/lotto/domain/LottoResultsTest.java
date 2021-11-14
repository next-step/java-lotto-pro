package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @DisplayName("로또 결과물 생성")
    @Test
    void constructLottoResults() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.FIFTH, LottoResult.MISS));
        assertThat(lottoResults).isEqualTo(new LottoResults(Arrays.asList(LottoResult.FIFTH, LottoResult.MISS)));
    }

    @DisplayName("통계 생성")
    @Test
    void makeStatistics() {
        LottoResults lottoResults = new LottoResults(
            Arrays.asList(LottoResult.FIFTH, LottoResult.FIFTH, LottoResult.MISS, LottoResult.MISS));

        Map<LottoResult, Long> resultCounts = new HashMap<>();
        resultCounts.put(LottoResult.FIFTH, 2L);
        resultCounts.put(LottoResult.MISS, 2L);
        assertThat(lottoResults.makeStatistics()).isEqualTo(
            new LottoStatistics(resultCounts, new EarningRate(BigDecimal.valueOf(2.5))));
    }
}
