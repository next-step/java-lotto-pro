package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTest {

    @ValueSource(ints = {1, 45})
    @ParameterizedTest(name = "숫자가 {0}인 Number 를 생성한다.")
    void creator(int number) {
        Number numberObject = new Number(number);
        assertEquals(number, numberObject.getNumber());
    }

    @ValueSource(ints = {0, 46})
    @ParameterizedTest(name = "{0}인 Number 를 생성하려고 하면, IllegalArgumentsException 발생")
    void creator_fail(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(number))
                .withMessage("로또 숫자는 1~45 사이의 숫자여야 합니다.");
    }
}