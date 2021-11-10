package lotto.domain;

import lotto.enums.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    void statistics_결과통계_1등하나() {
        Lottos lottos = Lottos.from(Arrays.asList(
                Lotto.from(Arrays.asList(1,2,3,4,5,6)),
                Lotto.from(Arrays.asList(2,3,4,5,6,7)),
                Lotto.from(Arrays.asList(1,2,4,5,6,7)),
                Lotto.from(Arrays.asList(10,20,30,40,41,44)),
                Lotto.from(Arrays.asList(18,20,23,25,32,33)),
                Lotto.from(Arrays.asList(3,4,5,9,10,20))
        ));
        Lotto winningLotto = Lotto.from("3,4,5,9,10,20", "11");
        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        assertThat(winningStatistics.getRankHitsCount(Ranking.FIRST)).isEqualTo(1);
    }

    @Test
    void statistics_결과통계_2등_보너스볼() {
        Lottos lottos = Lottos.from(Arrays.asList(
                Lotto.from(Arrays.asList(1,2,3,4,5,6)),
                Lotto.from(Arrays.asList(2,3,4,5,6,7)),
                Lotto.from(Arrays.asList(1,2,4,5,6,7)),
                Lotto.from(Arrays.asList(10,20,30,40,41,44)),
                Lotto.from(Arrays.asList(18,20,23,25,32,33)),
                Lotto.from(Arrays.asList(3,4,5,9,10,20))
        ));
        Lotto winningLotto = Lotto.from("3,4,5,9,10,30", "20");
        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        assertThat(winningStatistics.getRankHitsCount(Ranking.SECOND_BONUS)).isEqualTo(1);
    }
}
