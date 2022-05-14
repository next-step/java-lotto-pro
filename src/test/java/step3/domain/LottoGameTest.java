package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void beforeEach() {
        lottoGame = new LottoGame();
    }

    @ParameterizedTest(name = "구입가능개수 반환 ({0} : {1})")
    @CsvSource(value = {"1000:1", "5000:5", "100:0"}, delimiter = ':')
    void 구입가능개수_반환(int money, int expected) {
        assertThat(LottoGame.ableToBuyLottoCount(money)).isEqualTo(expected);
    }

    @Test
    void 구입가능개수만큼_로또_생성() {
        List<Lotto> lottos = lottoGame.buy(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void 지난주_당첨번호로_로또_생성() {
        Lotto winnerLotto = lottoGame.createWinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winnerLotto).isInstanceOf(Lotto.class);
    }
}