import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void match() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,5,6,7,8"), new Lotto("1,2,3,7,8,9")));
        lottos.checkMatch(new Lotto("1,2,3,4,11,12"));
        assertThat(lottos.getMatchLottoCount(LottoReward.FIFTH)).isEqualTo(1);
        assertThat(lottos.getMatchLottoCount(LottoReward.FOURTH)).isEqualTo(1);
    }

    @Test
    void getProfitTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,5,6,7,8"), new Lotto("1,2,3,7,8,9")));
        lottos.checkMatch(new Lotto("1,2,3,4,11,12"));
        assertThat(lottos.getProfit()).isEqualTo(55000);
    }

    @Test
    void matchFirst() throws Exception {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,6")));
        winLotto.setBonusNumber(new LottoNumber("7"));
        lottos.checkMatch(winLotto);
        assertThat(lottos.getMatchLottoCount(LottoReward.FIRST)).isEqualTo(1);
    }

    @Test
    void matchSecond() throws Exception {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,7")));
        winLotto.setBonusNumber(new LottoNumber("7"));
        lottos.checkMatch(winLotto);
        assertThat(lottos.getMatchLottoCount(LottoReward.SECOND)).isEqualTo(1);
    }

    @Test
    void matchThree() throws Exception {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        Lottos lottos = new Lottos(Arrays.asList(new Lotto("1,2,3,4,5,8")));
        winLotto.setBonusNumber(new LottoNumber("7"));
        lottos.checkMatch(winLotto);
        assertThat(lottos.getMatchLottoCount(LottoReward.THREE)).isEqualTo(1);
    }
}
