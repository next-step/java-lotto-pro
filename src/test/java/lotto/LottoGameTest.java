package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    void 구입금액이_음수인_경우() {
        assertThatThrownBy(() -> new LottoGame(-1))
                .isInstanceOf(RuntimeException.class);
    }

}
