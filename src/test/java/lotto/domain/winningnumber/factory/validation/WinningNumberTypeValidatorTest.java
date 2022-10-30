package lotto.domain.winningnumber.factory.validation;

import static lotto.domain.winningnumber.factory.validation.WinningNumberValidator.ERROR_WINNING_NUMBER_TYPE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTypeValidatorTest {

    WinningNumberValidator validator = new WinningNumberTypeValidator();
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
    @DisplayName("당첨번호에 숫자가 아닌 값이 있으면 EX 발생")
    @ValueSource(strings = {"a", "@", "ㄱ"})
    void number_type_ex(String ex) {
        winningNumbers.add(ex);
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(winningNumbers))
                .withMessageContaining(ERROR_WINNING_NUMBER_TYPE_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호에 숫자만 있으면 통과")
    void number_type_success() {
        assertThatNoException().isThrownBy(() -> validator.validate(winningNumbers));
    }
}
