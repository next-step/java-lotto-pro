package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 구입금액에_따라_갯수를_계산한다() {
        assertThat(new Game(14000).getUserLotto().getLottoNumbers()).hasSize(14);
        assertThatThrownBy(() -> new Game(900))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Game(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Game(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}