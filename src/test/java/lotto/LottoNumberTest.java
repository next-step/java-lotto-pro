package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 24, 45})
    @DisplayName("로또 번호가 1 ~ 45 사이인지 확인")
    void 로또_번호_범위_확인(int number) {
        // given
        final LottoNumber lottoNumber = LottoNumber.valueOf(number);

        // when & then
        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 300})
    @DisplayName("로또 번호가 유효하지 않은 때")
    void 로또_번호_유효하지_않은_번호가_입력될떄(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}