package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {

    @Test
    void createLottos() {
        assertThat(new Lottos(10000).lottosSize()).isEqualTo(10);
    }

    @Test
    void createLottos_금액부족() {
        assertThatThrownBy(() -> new Lottos(999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareLottos() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(1,2,3,7,8,9))),
                new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,8,9))),
                new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,9))),
                new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)))
        ));

        lottos.compareLottos(winningLotto);

        assertAll(
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.THREE)).isEqualTo(1),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.FOUR)).isEqualTo(1),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.FIVE)).isEqualTo(1),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.SIX)).isEqualTo(2)
        );
    }
}
