package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @Test
    @DisplayName("숫자가 같은지 검증")
    void verifyNumberSame() {
        Number one = Number.of(1);
        Number expected = Number.of(1);

        assertAll(
                () -> assertEquals(expected, one),
                () -> assertEquals(expected.getNumber(), one.getNumber())
        );
    }

    @ParameterizedTest(name = "숫자의 범위를 벗어난 값({0})이면 IllegalArgumentException가 발생")
    @ValueSource(ints = {-1, 46})
    void inputOutOfRangeNumber(int invalidNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Number.of(invalidNumber))
                .withMessage("로또 숫자 범위를 벗어났습니다.");
    }
}
