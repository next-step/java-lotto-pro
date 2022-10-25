package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StatisticsResultTest {

    @Test
    @DisplayName("당첨 통계 결과 생성 성공")
    public void constructor() {
        Ranks ranks = new Ranks();
        ranks.add(Rank.THIRD);
        ranks.add(Rank.THIRD);
        double profit = 10000.0;

        StatisticsResult statisticsResult = new StatisticsResult(ranks.getCountsOfRanks(), profit);
        Map<Rank, Integer> countsOfRanks = statisticsResult.getCountsOfRanks();

        assertAll(
                () -> assertThat(statisticsResult.getProfit()).isEqualTo(profit),
                () -> assertThat(countsOfRanks).hasSize(1),
                () -> assertThat(countsOfRanks).containsEntry(Rank.THIRD, 2)
        );
    }
}
