package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    void 숫자_이외_로또수() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCount("!!"))
                .withMessage(LottoCount.NOT_NUMBER);
    }
}
