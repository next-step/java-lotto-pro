package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    @DisplayName("금액은 숫자만 입력")
    void money_is_only_number() {
        assertThatThrownBy(() -> Money.of("as1f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("최대 구매 가능 금액 초과")
    void integer_max_value_exceeded() {
        assertThatThrownBy(() -> Money.of("1000000000000000000000000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 구매 금액을 초과했습니다.");
    }

    @Test
    @DisplayName("금액은 양수만 입력")
    void money_is_not_negative() {
        assertThatThrownBy(() -> Money.of("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력 불가능합니다.");
    }
}
