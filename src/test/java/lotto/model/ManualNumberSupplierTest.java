package lotto.model;

import static lotto.model.ManualNumberSupplier.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ManualNumberSupplierTest {
    @Test
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(ManualNumberSupplier::new).withMessage(EMPTY_NUMBERS_ERR_MSG);
    }

    @Test
    void getNumbers() {
        assertThat(new ManualNumberSupplier(1, 4, 16, 26, 31, 44).getNumbers()).containsOnly(
            new Number(1), new Number(4), new Number(16), new Number(26), new Number(31), new Number(44)
        );
    }
}
