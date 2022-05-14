package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 숫자를 필드에 셋팅하고 LottoNumber 객체를 생성한다.")
    @ValueSource(ints = {1, 10, 25, 45})
    void LottoNumber_생성(int input) {
        assertThat(LottoNumber.of(input))
                .isExactlyInstanceOf(LottoNumber.class)
                .hasFieldOrPropertyWithValue("number", input);
    }

    @ParameterizedTest
    @DisplayName("로또 숫자 생성 시 최소 혹은 최대값을 벗어나면 에러를 발생시킨다.")
    @ValueSource(ints = {-1, -10, 46, 50})
    void LottoNumber_범위오류(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 %d와 %d 사이 입니다!", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }
}