package lotto.domain.winningnumber.factory.validation;

import static lotto.domain.winningnumber.factory.validation.WinningNumberValidator.ERROR_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RangeValidatorTest {

    WinningNumberValidator validator = new RangeValidator();
    Set<String> winningNumbers = new HashSet<>();

    @BeforeEach
    void beforeEach() {
        winningNumbers.add("1");
        winningNumbers.add("2");
        winningNumbers.add("3");
        winningNumbers.add("4");
        winningNumbers.add("5");
    }

    @ParameterizedTest
    @DisplayName("1~45 사이 값이 아니면 EX 발생")
    @ValueSource(strings = {"46", "0", "-1"})
    void range_ex(String ex) {
        winningNumbers.add(ex);
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(winningNumbers))
                .withMessageContaining(ERROR_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("1~45 사이 값이면 통과")
    void range_success() {
        assertThatNoException().isThrownBy(() -> validator.validate(winningNumbers));

    }
}
