package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void number_생성(int inputNumber) {
        // given, when
        Number number = new Number(inputNumber);

        // then
        assertThat(number).isEqualTo(new Number(inputNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void number_생성_범위_초과(int inputNumber) {
        // given, when, then
        assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "의 숫자만 입력 가능합니다. (입력값: " + inputNumber + ")");
    }
}