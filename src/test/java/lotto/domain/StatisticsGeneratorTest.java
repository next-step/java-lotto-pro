package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StatisticsGeneratorTest {

    @Test
    @DisplayName("당첨 통계 생성 성공")
    public void constructor() {
        Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(firstLotto, secondLotto));
        WinningLotto winninglotto = new WinningLotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        StatisticsResult statisticsResult = StatisticsGenerator.create(lottoTicket, winninglotto);
        Map<Rank, Integer> countsOfRanks = statisticsResult.getCountsOfRanks();

        assertAll(
                () -> assertThat(countsOfRanks.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(countsOfRanks.get(Rank.SECOND)).isZero(),
                () -> assertThat(countsOfRanks.get(Rank.THIRD)).isZero(),
                () -> assertThat(countsOfRanks.get(Rank.FOURTH)).isZero(),
                () -> assertThat(countsOfRanks.get(Rank.MISS)).isEqualTo(1),
                () -> assertThat(statisticsResult.getYields()).isEqualTo(1000000)
        );
    }
}
