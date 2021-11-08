package lotto.domain;

import lotto.enums.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {

    @Test
    void statistics_결과통계_1등하나() {
        Lottos lottos = Lottos.from(Arrays.asList(
                Lotto.from("1,2,3,4,5,6"),
                Lotto.from("2,3,4,5,6,7"),
                Lotto.from("1,2,4,5,6,7"),
                Lotto.from("10,20,30,40,41,44"),
                Lotto.from("18,20,23,25,32,33"),
                Lotto.from("3,4,5,9,10,20")
        ));
        Lotto winningLotto = Lotto.from("3,4,5,9,10,20");
        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        assertThat(winningStatistics.getRankHitsCount(Ranking.FIRST)).isEqualTo(1);
    }
}
