package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Money는")
public class MoneyTest {
    @DisplayName("숫자가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"abcd", "!@#$"})
    void validateNumber(String price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(price));
    }

    @DisplayName("1000원 단위가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1001"})
    void validateStandard(String price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(price));
    }
}
