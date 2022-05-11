package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 20, 30, 40, 45})
    @DisplayName("유효한 로또 숫자 확인")
    public void Check_valid_lotto_number(int number) {
        new LottoNo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46, 50})
    @DisplayName("문제가 있는 로또 숫자 확인")
    public void Check_invalid_lotto_number(int number) {
        assertThatThrownBy(() -> {
            new LottoNo(number);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("유효하지 않은 로또 번호입니다.");
    }
}
