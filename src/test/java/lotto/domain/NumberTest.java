package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("1에서 45 사이의 숫자를 입력한 경우 Number 가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11, 20, 40, 45})
    void possible_number(int input) {

        assertThat(Number.from(input)).isInstanceOf(Number.class);
    }

    @DisplayName("1에서 45 사이의 숫자가 아니면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void impossible_number(int input) {

        assertThatThrownBy(() -> Number.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 숫자이면 동일하다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "40:40", "28:28"}, delimiter = ':')
    void equal_number(int first, int second) {

        Number number1 = Number.from(first);
        Number number2 = Number.from(second);

        assertThat(number1).isEqualTo(number2);
    }

    @DisplayName("다른 숫자이면 동일하지 않다.")
    @ParameterizedTest
    @CsvSource(value = {"1:45", "40:23", "28:16"}, delimiter = ':')
    void not_equal_number(int first, int second) {

        Number number1 = Number.from(first);
        Number number2 = Number.from(second);

        assertThat(number1).isNotEqualTo(number2);
    }

    @DisplayName("Number 를 출력하면 입력한 숫자가 출력된다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "45:45", "20:20"}, delimiter = ':')
    void string_number(int target, String expect) {

        assertThat(Number.from(target).toString()).isEqualTo(expect);
    }
}
