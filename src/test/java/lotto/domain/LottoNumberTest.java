package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void validate_1_45_숫자_검증(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);
        assertThat(lottoNumber.getValue()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 47})
    void validate_예외_1_45_숫자_검증(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Lotto numbers range from 1 to 45.");
    }
}
