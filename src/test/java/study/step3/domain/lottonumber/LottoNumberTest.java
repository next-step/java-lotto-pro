package study.step3.domain.lottonumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.message.LottoMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("주어진 [int]형 로또 번호로 생성한다")
    void create_lotto_number_by_int_test() {
        LottoNumber lottoNumber = LottoNumber.of(14);
        assertThat(lottoNumber.toString()).isEqualTo("14");
    }

    @Test
    @DisplayName("주어진 [String]형 로또 번호로 생성한다")
    void create_lotto_number_by_string_test() {
        LottoNumber lottoNumber = LottoNumber.of("14");
        assertThat(lottoNumber.toString()).isEqualTo("14");
    }

    @Test
    @DisplayName("주어진 로또 번호가 [45] 초과할 경우 [IllegalArgumentException] 예외처리한다")
    void create_lotto_number_with_greater_than_maximum_test() {
        assertThatThrownBy(() -> LottoNumber.of("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoMessage.ERROR_LOTTO_NUMBER_IS_LESS_THAN_MAXIMUM.message());
    }

    @Test
    @DisplayName("주어진 로또 번호가 [1] 미만일 경우 [IllegalArgumentException] 예외처리한다")
    void create_lotto_number_with_less_than_minimum_test() {
        assertThatThrownBy(() -> LottoNumber.of("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoMessage.ERROR_LOTTO_NUMBER_IS_GREATER_THAN_MINIMUM.message());
    }
}
