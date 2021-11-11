package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private static Lottos lottos = null;

    @BeforeEach
    void setUp() {
        lottos = Lottos.from(Arrays.asList(
                Lotto.from(Arrays.asList(1,2,3,4,5,6)),
                Lotto.from(Arrays.asList(2,3,4,5,6,7)),
                Lotto.from(Arrays.asList(1,2,4,5,6,7)),
                Lotto.from(Arrays.asList(10,20,30,40,41,44)),
                Lotto.from(Arrays.asList(18,20,23,25,32,33)),
                Lotto.from(Arrays.asList(3,4,5,9,10,20))
        ));
    }

    @Test
    void getMatchingCounts_복수_로또_생성_중_1등당첨() {
        WinningLotto winningLotto = WinningLotto.from("3,4,5,9,10,20", "1");
        List<MatchResult> matchList = lottos.getMatchingCounts(winningLotto);
        assertThat(matchList.contains(MatchResult.from(6, false))).isTrue();
    }

    @Test
    void getMatchingBonus_복수_로또_생성_보너스번호_일치() {
        WinningLotto winningLotto = WinningLotto.from("3,4,5,9,10,45", "20");
        List<MatchResult> matchList = lottos.getMatchingCounts(winningLotto);
        assertThat(matchList.contains(MatchResult.from(5, true))).isTrue();

    }

    @Test
    void buy_로또구매_생성() {
        Lottos lottos = Lottos.buy(10);
        assertThat(lottos.count()).isEqualTo(10);
    }
}
