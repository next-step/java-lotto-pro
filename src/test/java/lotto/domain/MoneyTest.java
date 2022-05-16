package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "a", "%", "500"})
    @DisplayName("숫자 이외의 값 또는 로또 1장 최소 구입 금액보다 적을 경우 Exception 발생 확인")
    void validateInputMoney(String input) {
        assertThatThrownBy(() -> {
            new Money(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
