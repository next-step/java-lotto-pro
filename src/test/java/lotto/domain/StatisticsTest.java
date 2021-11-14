package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    @DisplayName("로또 통계 생성")
    @Test
    void constructStatistics() {
        Statistics statistics = new Statistics(Collections.singletonMap(Rank.FIFTH, 1L),
            new EarningRate(BigDecimal.ONE));

        assertThat(statistics).isEqualTo(
            new Statistics(Collections.singletonMap(Rank.FIFTH, 1L), new EarningRate(BigDecimal.ONE)));
    }
}