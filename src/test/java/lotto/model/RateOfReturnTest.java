package lotto.model;

import static lotto.model.RateOfReturn.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    @Test
    @DisplayName("음수가 들어올 경우 예외 발생")
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> new RateOfReturn(-0.1)
        ).withMessageContaining(NEGATIVE_VALUE_ERR_MSG);
    }

    @Test
    void isLosingMoney() {
        assertThat(new RateOfReturn(1).isLosingMoney()).isFalse();
        assertThat(new RateOfReturn(0.99).isLosingMoney()).isTrue();
    }
}
