package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {

    @Test
    void createLottos() {
        assertThat(new Lottos(10000).lottosCount()).isEqualTo(10);
    }

    @Test
    void createLottos_금액부족() {
        assertThatThrownBy(() -> new Lottos(999)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottos_잔돈발생() {
        assertThatThrownBy(() -> new Lottos(1010)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareLottos() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 9);

        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(1,2,3,4,8,9)),
                new Lotto(Arrays.asList(1,2,3,4,5,9)),
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,6))
        ));

        WinningStatus winningStatus = lottos.compareLottos(winningLotto);

        assertAll(
                () -> assertThat(winningStatus.findWinningCount(MatchPoint.FIFTH)).isEqualTo(1),
                () -> assertThat(winningStatus.findWinningCount(MatchPoint.FOURTH)).isEqualTo(1),
                () -> assertThat(winningStatus.findWinningCount(MatchPoint.THIRD)).isEqualTo(0),
                () -> assertThat(winningStatus.findWinningCount(MatchPoint.SECOND)).isEqualTo(1),
                () -> assertThat(winningStatus.findWinningCount(MatchPoint.FIRST)).isEqualTo(2)
        );
    }
}
