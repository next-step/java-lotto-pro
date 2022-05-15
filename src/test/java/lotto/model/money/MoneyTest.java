package lotto.model.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("입력된 금액이 0보다 작을 경우 예외처리")
    void 입력된_금액이_0원보다_작을_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Money("s"));
    }

}
