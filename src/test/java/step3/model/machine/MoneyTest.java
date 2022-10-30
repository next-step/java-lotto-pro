package step3.model.machine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.NumberValidator;
import step3.model.lotto.LottoNumber;

class MoneyTest {

    @Test
    void 티켓_수_검증() {
        Money money = new Money("5000");
        assertThat(money.availableTicketCount(1000)).isEqualTo(5);
        assertThat(money.availableTicketCount(700)).isEqualTo(7);
    }
    @ParameterizedTest
    @ValueSource(strings ={"-1", "a", "$"})
    void 잘못된_돈_입력_에러(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}