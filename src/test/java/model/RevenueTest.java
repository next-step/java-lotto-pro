package model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RevenueTest {

    @Test
    void 수익률을_구한다() {
        Map<LottoRankType, Integer> stats = new HashMap<>();
        stats.put(LottoRankType.RANK_THREE, 1);
        int price = 1000;

        double percent = new Revenue(stats).getPercent(price);

        assertThat(percent).isEqualTo(1500.0);
    }
}