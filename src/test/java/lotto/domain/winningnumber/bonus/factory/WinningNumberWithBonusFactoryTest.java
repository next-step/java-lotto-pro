package lotto.domain.winningnumber.bonus.factory;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberWithBonusFactoryTest {

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
    @DisplayName("당첨번호와 다른 값 입력시 성공")
    @ValueSource(strings = {"7", "8", "9", "10", "45", "30"})
    void duplicate_success(String bonus) {
        assertThatNoException().isThrownBy(
                () -> new WinningNumberWithBonusFactory(winningNumbers).createWinningNumberWithBonus(bonus));
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 중복 값 입력시 EX 발생")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void duplicate_ex(String bonus) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new WinningNumberWithBonusFactory(winningNumbers).createWinningNumberWithBonus(bonus))
                .withMessageContaining("[ERROR]");
    }
}
