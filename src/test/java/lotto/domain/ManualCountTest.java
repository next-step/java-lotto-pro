package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualCountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void 양수_생성(String value) {
        assertThat(ManualCount.from(value)).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void 양수만_생성가능(String value) {
        assertThatThrownBy(() -> ManualCount.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,1000,5000", "10,25,250"})
    void 곱하기(String a, int b, int expected) {
        assertThat(ManualCount.from(a).multiply(b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void 횟수만큼_리스트_변환(int size) {
        assertThat(ManualCount.from(String.valueOf(size)).toList(Object::new)).hasSize(size);
    }
}
