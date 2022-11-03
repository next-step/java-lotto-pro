package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {

    @Test
    @DisplayName("Winning에 따른 구매 로또 개수 테스트")
    void valid_lotto_count_by_winning_test() {

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,4,5,6"));
        lottoList.add(new Lotto("1,2,3,4,5,7"));
        lottoList.add(new Lotto("1,2,3,4,5,8"));
        lottoList.add(new Lotto("1,2,3,4,8,9"));
        lottoList.add(new Lotto("1,2,3,8,9,10"));
        lottoList.add(new Lotto("1,2,8,9,10,11"));

        Lottos lottos = new Lottos(lottoList);

        WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
        Statistics statistics = new Statistics(lottos, winLotto);

        assertThat(statistics.getLottoCntByWinning(Winning.FIRST)).isEqualTo(1);
        assertThat(statistics.getLottoCntByWinning(Winning.SECOND)).isEqualTo(1);
        assertThat(statistics.getLottoCntByWinning(Winning.THIRD)).isEqualTo(1);
        assertThat(statistics.getLottoCntByWinning(Winning.FOURTH)).isEqualTo(1);
        assertThat(statistics.getLottoCntByWinning(Winning.FIFTH)).isEqualTo(1);
        assertThat(statistics.getLottoCntByWinning(Winning.MISS)).isEqualTo(1);

    }

    @Test
    @DisplayName("보너스 볼 매치 여부에 따른 등수 테스트")
    void winning_info_by_matchBonus_test() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,4,5,7"));
        Lottos lottos = new Lottos(lottoList);
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");
        assertThat(new Statistics(lottos, winLotto).getRewardsByWinning()).isEqualTo(Winning.SECOND.getReward());
    }

    @Test
    @DisplayName("수익률 정상 산출 테스트")
    void valid_yield_test() {

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,11,12,13"));
        lottoList.add(new Lotto("11,12,13,14,15,16"));
        lottoList.add(new Lotto("12,13,14,15,16,17"));
        Lottos lottos = new Lottos(lottoList);
        WinLotto winLotto = new WinLotto("1,2,3,4,5,6", "7");

        Statistics statistics = new Statistics(lottos, winLotto);
        assertThat(statistics.getYield(new Payment("14000"))).isEqualTo(0.35);
    }
}
