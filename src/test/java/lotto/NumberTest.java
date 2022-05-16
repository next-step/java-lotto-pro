package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void 로또번호_생성(int input) {
        Number number = new Number(input);

        assertThat(number).isEqualTo(new Number(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 451})
    void 예외테스트_로또번호_생성(int input) {
        assertThatThrownBy(() ->
                new Number(input)).isInstanceOf(IllegalArgumentException.class);
    }

}