package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    @DisplayName("로또 통계 생성")
    @Test
    void constructLottoStatistics() {
        LottoStatistics lottoStatistics = new LottoStatistics(Collections.singletonMap(LottoResult.FIVE, 1L),
            new EarningRate(BigDecimal.ONE));

        assertThat(lottoStatistics).isEqualTo(
            new LottoStatistics(Collections.singletonMap(LottoResult.FIVE, 1L), new EarningRate(BigDecimal.ONE)));
    }
}