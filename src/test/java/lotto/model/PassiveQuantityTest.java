package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("PassiveQuantity는 ")
public class PassiveQuantityTest {
    @DisplayName("숫자가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"abcd", "!@#$"})
    void validateNumber(String quantity) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PassiveQuantity(quantity));
    }
}
