package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 당첨로또를_생성한다() {
        assertThat(new WinningLotto("1,2,3,4,5,6")).isEqualTo(new WinningLotto("1,2,3,4,5,6"));
    }
}