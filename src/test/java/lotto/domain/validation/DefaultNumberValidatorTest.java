package lotto.domain.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultNumberValidatorTest {

    NumberValidator validator = new DefaultNumberValidator();

    @ParameterizedTest
    @DisplayName("쉼표(,) 가 포함되지 않으면 EX 발생")
    @ValueSource(strings = {"test", "123456"})
    void comma(String ex) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining("[ERROR]");
    }
}
