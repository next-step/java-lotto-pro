package lotto.domain.winningnumber.validation;

import static lotto.domain.winningnumber.validation.WinningNumberValidator.ERROR_COUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountValidatorTest {

    WinningNumberValidator validator = new CountValidator();
    Set<String> winningNumbers = new HashSet<>();

    @BeforeEach
    void beforeEach() {
        winningNumbers.add("1");
        winningNumbers.add("2");
        winningNumbers.add("3");
        winningNumbers.add("4");
        winningNumbers.add("5");
    }

    @Test
    @DisplayName("당첨번호의 갯수가 6개가 아니면 EX 발생")
    void count_ex() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(winningNumbers))
                .withMessageContaining(ERROR_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("당첨번호의 갯수가 6개면 통과")
    void count_success() {
        winningNumbers.add("6");
        assertThatNoException().isThrownBy(() -> validator.validate(winningNumbers));
    }
}
