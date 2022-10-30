package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StatisticsResultTest {

    @Test
    @DisplayName("당첨 통계 결과의 생성 작업이 정상적으로 동작한다.")
    public void constructor() {
        Ranks ranks = new Ranks();
        ranks.add(Rank.THIRD);
        ranks.add(Rank.THIRD);
        double value = 10000.0;

        StatisticsResult statisticsResult = new StatisticsResult(ranks.getCountsOfRanks(), new Yields(value));
        Map<Rank, Integer> countsOfRanks = statisticsResult.getCountsOfRanks();
        Yields yields = statisticsResult.getYields();

        assertAll(
                () -> assertThat(yields.getValue()).isEqualTo(value),
                () -> assertThat(countsOfRanks).containsEntry(Rank.THIRD, 2)
        );
    }
}
