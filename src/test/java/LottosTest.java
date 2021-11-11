import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THREE"}, delimiter = ':')
    void matchTest(String numbers, String lottoReward) throws Exception {
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(numbers)));
        winLotto.setBonusNumber(new LottoNumber("7"));
        lottos.checkMatch(winLotto);
        assertThat(lottos.getMatchLottoCount(LottoReward.valueOf(lottoReward))).isEqualTo(1);
    }
}
