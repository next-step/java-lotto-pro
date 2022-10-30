package lotto.domain.winningnumber.factory.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultWinningNumberValidatorTest {

    WinningNumberValidator validator = new DefaultWinningNumberValidator();

    @ParameterizedTest
    @DisplayName("쉼표(,) 가 포함되지 않으면 EX 발생")
    @ValueSource(strings = {"test", "123456"})
    void comma(String ex) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining(WinningNumberValidator.ERROR_SEPARATOR_MESSAGE);
    }
}
