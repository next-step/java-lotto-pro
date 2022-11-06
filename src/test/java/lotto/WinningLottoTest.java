package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    public void match_test() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        assertThat(winningLotto.match(lotto)).isEqualTo(6);
    }

}