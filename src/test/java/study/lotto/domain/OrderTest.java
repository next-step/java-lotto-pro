package study.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                .hasMessage("[ERROR] The given string contains characters that cannot be converted to numbers.");
    }
}
