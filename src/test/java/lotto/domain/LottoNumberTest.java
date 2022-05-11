package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15, 20, 25, 30, 35, 40, 45})
    @DisplayName("1~45 사이의 숫자를 이용해 LottoNumber 객체를 생성할 수 있다.")
    void generate01(int input) {
        // given & when
        LottoNumber lottoNumber = LottoNumber.from(input);

        // then
        assertThat(lottoNumber.getNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("1~45 범위 외의 숫자를 이용해 LottoNumber 객체를 생성하면 IllegalArgumentException이 발생한다.")
    void exception01(int input) {
        // given & when & then
        assertThatThrownBy(() -> LottoNumber.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining(String.valueOf(input));
    }
}