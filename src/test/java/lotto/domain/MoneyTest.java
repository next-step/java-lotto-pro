package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("금액은 숫자만 입력")
    void money_is_only_number() {
        Assertions.assertThatThrownBy(() -> new Money("as1f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("최대 구매 가능 금액 초과")
    void integer_max_value_exceeded() {
        Money money = new Money("100000000000000000");
        Assertions.assertThatThrownBy(money::parseAmount)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("최대 구매 금액을 초과했습니다.");
    }
}
