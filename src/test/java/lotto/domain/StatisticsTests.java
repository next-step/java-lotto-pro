package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTests {

    @Test
    @DisplayName("수익률을 계산한다")
    void totalReward() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.MISS);
        ranks.add(Rank.FIVE);

        Statistics statistics = new Statistics(ranks);
        assertThat(statistics.totalReward()).isEqualTo(new BigDecimal("2.50"));
    }
}
