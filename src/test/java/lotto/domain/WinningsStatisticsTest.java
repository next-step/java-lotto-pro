package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningsStatisticsTest {

    @DisplayName("당첨로또와 구입한 로또들을 비교해서 당첨결과를 통계낸다.")
    @Test
    void getRankHitsCount() {
        Lotto winningLotto = Lotto.from("1,2,3,4,5,6");
        Lottos lottos = Lottos.from(Arrays.asList(
                Lotto.from("1,2,3,4,5,6"),
                Lotto.from("1,2,3,4,5,7"),
                Lotto.from("1,2,3,11,12,13"),
                Lotto.from("1,2,3,21,22,23"),
                Lotto.from("11,12,13,4,5,6")
        ));

        WinningsStatistics winningsStatistics = WinningsStatistics.statistics(winningLotto, lottos);

        assertAll(
                () -> assertThat(winningsStatistics.getRankHitsCount(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(winningsStatistics.getRankHitsCount(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(winningsStatistics.getRankHitsCount(Rank.FOURTH)).isEqualTo(3)
        );
    }

}
