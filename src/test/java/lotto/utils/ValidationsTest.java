package lotto.utils;

import static lotto.utils.Validations.requireNotNull;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ValidationsTest {
    @Test
    void name() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> requireNotNull(null, "메시지"))
                .withMessage("메시지");
    }
}
