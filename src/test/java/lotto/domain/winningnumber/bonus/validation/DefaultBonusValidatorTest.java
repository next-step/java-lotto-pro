package lotto.domain.winningnumber.bonus.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultBonusValidatorTest {

    Set<Integer> winningNumbers = new HashSet<>();

    @BeforeEach
    void beforeEach() {
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 중복되지 않으면 통과")
    @ValueSource(strings = {"7", "8", "9", "10", "20", "45"})
    void duplicate_success(String bonus) {
        assertThatNoException().isThrownBy(() -> new DefaultBonusValidator(winningNumbers).validate(bonus));
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 중복되면 EX 발생")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void duplicate_ex(String bonus) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new DefaultBonusValidator(winningNumbers).validate(bonus))
                .withMessageContaining("[ERROR]");
    }
}
