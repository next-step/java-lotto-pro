package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest(name = "로또 번호는 1부터 45사이의 숫자가 아니면 오류를 반환한다")
    @ValueSource(strings = {"0", "46"})
    void invalidStringNumberInputTest(String number) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Number(number))
                .withMessageContaining("유효하지 않은 범위의 숫자입니다.");
    }

    @ParameterizedTest(name = "로또 번호는 숫자가 아니면 오류를 반환한다")
    @ValueSource(strings = {"a", "숫자", "%"})
    void invalidStringInputTest(String number) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Number(number))
                .withMessageContaining("유효하지 않은 값입니다.");
    }

    @ParameterizedTest(name = "로또 번호는 1부터 45사이의 숫자가 아니면 오류를 반환한다")
    @ValueSource(ints = {0, 46})
    void invalidIntegerNumberInputTest(int number) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Number(number))
                .withMessageContaining("유효하지 않은 범위의 숫자입니다.");
    }
}
