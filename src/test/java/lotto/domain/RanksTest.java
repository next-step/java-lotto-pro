package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RanksTest {

    @DisplayName("로또 결과물 생성")
    @Test
    void constructRanks() {
        Ranks ranks = new Ranks(Arrays.asList(Rank.FIFTH, Rank.MISS));
        assertThat(ranks).isEqualTo(new Ranks(Arrays.asList(Rank.FIFTH, Rank.MISS)));
    }

    @DisplayName("통계 생성")
    @Test
    void makeStatistics() {
        Ranks ranks = new Ranks(
            Arrays.asList(Rank.FIFTH, Rank.FIFTH, Rank.MISS, Rank.MISS));

        Map<Rank, Long> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FIFTH, 2L);
        rankCounts.put(Rank.MISS, 2L);
        assertThat(ranks.makeStatistics()).isEqualTo(
            new Statistics(rankCounts, new EarningRate(BigDecimal.valueOf(2.5))));
    }
}
