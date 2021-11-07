package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winpolicy.WinPolicy;
import lotto.domain.winstatistics.WinStatistics;

public class WinStatisticsTest {
  @DisplayName("수익율을 계산한다.")
  @Test
  void calculate_revenuRationgerate() {
    // given
    WinStatistics winStatistics = new WinStatistics();

    Lotto latestWinLottos = Lotto.valueOf("1","2","5","17","19","20");
    Lotto match_3 = Lotto.valueOf("1","2","5","27","29","30");
    Lotto match_none = Lotto.valueOf("31","32","35","37","39","30");

    Lottos buyLottos = Lottos.valueOf(match_3,
                                      match_none,
                                      match_none,
                                      match_none,
                                      match_none,
                                      match_none);

    // when
    winStatistics.analysis(latestWinLottos, buyLottos);

    // then
    assertThat(winStatistics.getRevenueRatioValue()).isEqualTo("0.83");
  }

  @DisplayName("로또들이 당첨전략에 몇개가 일치하는지 계산")
  @Test
  void calculate_winLottoCount() {
    // given
    WinStatistics winStatistics = new WinStatistics();

    Lotto latestWinLottos = Lotto.valueOf("1","2","5","17","19","20");
    Lotto match_3 = Lotto.valueOf("1","2","5","27","29","30");
    Lotto match_4 = Lotto.valueOf("1","2","5","17","29","30");
    Lotto match_none = Lotto.valueOf("31","32","35","37","39","30");

    Lottos buyLottos = Lottos.valueOf(match_3,
                                      match_3,
                                      match_4,
                                      match_none,
                                      match_none,
                                      match_none);

    // when
    winStatistics.analysis(latestWinLottos, buyLottos);

    // then
    assertThat(winStatistics.find(WinPolicy.THREE_MATCH).getCount()).isEqualTo(2);
    assertThat(winStatistics.find(WinPolicy.FOUR_MATCH).getCount()).isEqualTo(1);
    assertThat(winStatistics.find(WinPolicy.FIVE_MATCH).getCount()).isEqualTo(0);
  }
}
