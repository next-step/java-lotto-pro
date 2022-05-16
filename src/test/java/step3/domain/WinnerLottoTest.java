package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {
    @Test
    void valid_1등_로또_생성() {
        WinnerLotto winnerLotto = new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winnerLotto).isEqualTo(new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void invalid_1등_로또_생성() {
        assertThatThrownBy(() -> {
            new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}