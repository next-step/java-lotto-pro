package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MoneyTest {

    @Test
    @DisplayName("입력받은 값이 머니 객체가 같은지 검증")
    void verifyMoneySame() {
        Money ten = Money.of(10);

        assertAll(
                () -> assertEquals(Money.of(10), ten),
                () -> assertEquals(Money.of("10"), ten)
        );
    }

    @ParameterizedTest(name = "NULL이거나 EMPTY인 값({0})을 입력받으면 IllegalArgumentException이 발생")
    @NullAndEmptySource
    void inputNullAndEmptyValue(String invalidValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.of(invalidValue))
                .withMessage("Integer 타입 이외에 입력 받을 수 없습니다.");
    }

    @Test
    @DisplayName("입력받은 값이 Integer 값이 아닐 때 IllegalArgumentException 발생")
    void inputInvalidValue() {
        assertAll(
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> Money.of(Integer.MAX_VALUE + 1)),
                () -> assertThatIllegalArgumentException()
                        .isThrownBy(() -> Money.of("a"))
                        .withMessage("Integer 타입 이외에 입력 받을 수 없습니다.")
        );
    }

    @Test
    @DisplayName("입력받은 값이 음수 일 때 IllegalArgumentException 발생")
    void inputNegativeValue() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.of(-1))
                .withMessage("금액은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("제수로 나누었을 때 값이 맞는지 검증")
    void verifyDivideMoney() {
        Money money = Money.of(1000);

        assertEquals(100, money.divide(10));
    }
}
