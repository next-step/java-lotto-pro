package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 번호에 대한 테스트")
class LottoNoTest {

    @DisplayName("로또 번호에 문자열을 넘기면 예외가 발생한다")
    @Test
    void lotto_no_test() {
        assertThatThrownBy(() -> {
            new LottoNo("a");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("로또 번호에 로또번호 이외의 숫자를 넘기면 예외가 발생한다")
    @Test
    void lotto_no_test2() {
        assertThatThrownBy(() -> {
            new LottoNo(100);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }

    @DisplayName("로또 번호를 int or string 으로 넘기면 모두 int 로 반환되어야 한다")
    @Test
    void lotto_no_test3() {
        LottoNo string_lottoNo = new LottoNo("5");
        LottoNo int_lottoNo = new LottoNo(5);

        assertThat(string_lottoNo.getLottoNo()).isEqualTo(5);
        assertThat(int_lottoNo.getLottoNo()).isEqualTo(5);
    }
}
