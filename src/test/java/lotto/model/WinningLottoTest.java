package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningLottoTest {

    @Test
    void createWinningLotto() {
        assertThat(new WinningLotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)))).isNotEqualTo(new WinningLotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
    }

    @Test
    void compareWinningLottos() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        winningLotto.compareWinningLotto(new Lotto(new LottoNumbers(Arrays.asList(1,2,3,9,10,11))));

        assertAll(
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.THREE)).isEqualTo(1),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.FOUR)).isEqualTo(0),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.FIVE)).isEqualTo(0),
                () -> assertThat(winningLotto.findWinningCount(MatchPoint.SIX)).isEqualTo(0)
        );
    }
}
