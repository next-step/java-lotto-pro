package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @DisplayName("로또 결과물 생성")
    @Test
    void constructLottoResults() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE));
        assertThat(lottoResults).isEqualTo(new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE)));
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningRate() {
        LottoResults lottoResults = new LottoResults(
            Arrays.asList(LottoResult.THREE, LottoResult.THREE, LottoResult.NONE, LottoResult.NONE));
        assertThat(lottoResults.calculateEarningRate()).isEqualTo(new EarningRate(BigDecimal.valueOf(2.5)));
    }

}
