package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50})
    @DisplayName("로또 번호는 1 ~ 45 사이의 숫자")
    void lotto_number_1_45(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45 사이의 숫자입니다.");
    }
}
