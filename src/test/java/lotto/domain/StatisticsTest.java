package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {

    @Test
    @DisplayName("일치 개수에 따른 로또 건수 정상적으로 가져오는지 테스트")
    void valid_matched_lotto_count_test() {

        Lottos lottos = new Lottos();
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        lottos.addLotto(new Lotto("1,2,3,4,5,6"));
        lottos.addLotto(new Lotto("11,12,13,14,15,16"));
        lottos.addLotto(new Lotto("12,13,14,15,16,17"));

        Statistics statistics = new Statistics(lottos, winLotto);

        assertThat(statistics.getMatchedLottoCnt(6)).isEqualTo(1);

    }

    @Test
    @DisplayName("수익률 정상 산출 테스트")
    void valid_yield_test() {
        Lottos lottos = new Lottos();
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        lottos.addLotto(new Lotto("1,2,3,11,12,13"));
        lottos.addLotto(new Lotto("11,12,13,14,15,16"));
        lottos.addLotto(new Lotto("12,13,14,15,16,17"));

        Statistics statistics = new Statistics(lottos, winLotto);
        assertThat(statistics.getYield(new Payment("14000"))).isEqualTo(0.35);
    }
}
