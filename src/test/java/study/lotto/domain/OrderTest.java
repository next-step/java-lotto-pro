package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또의 주문 개수와 주문 가격을 검증하는 테스트")
class OrderTest {

    @Test
    void 문자_0이_입력되면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> {
            new Order("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string cannot contain zero.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "-2", "-3" })
    void 음수가_입력되면_IllegalArgumentException_발생(String totalAmount) {
        assertThatThrownBy(() -> {
            new Order(totalAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string cannot contain negative numbers.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "-", "14000%" })
    void 숫자로_변경할_수_없는_문자가_있으면_IllegalArgumentException_발생(String totalAmount) {
        assertThatThrownBy(() -> {
            new Order(totalAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string contains characters " +
                        "that cannot be converted to numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "100", "500", "800" })
    void 로또_가격보다_작은_금액이_입력되면_IllegalArgumentException_발생(String totalAmount) {
        assertThatThrownBy(() -> {
            new Order(totalAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] You must purchase at least one lotto.");
    }
}
