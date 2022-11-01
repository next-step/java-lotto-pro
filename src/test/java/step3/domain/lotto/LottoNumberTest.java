package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_CANNOT_BE_GREATER_THAN_END_INCLUSIVE;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_CANNOT_BE_LESS_THAN_START_INCLUSIVE;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호는 1보다 작을 수 없습니다.")
    void lottoNumberCannotBeLessThanStartInclusive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(LottoNumber.START_INCLUSIVE - 1))
                .withMessageContaining(LOTTO_NUMBER_CANNOT_BE_LESS_THAN_START_INCLUSIVE.getMessage());
    }

    @Test
    @DisplayName("로또번호는 45보다 클 수 없습니다.")
    void lottoNumberCannotBeGreaterThanEndInclusive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(LottoNumber.END_INCLUSIVE + 1))
                .withMessageContaining(LOTTO_NUMBER_CANNOT_BE_GREATER_THAN_END_INCLUSIVE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    @DisplayName("유효한 번호를 입력하여 로또 번호를 생성합니다.")
    void lottoCreateSuccess(int input) {
        LottoNumber lottoNumber = LottoNumber.of(input);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(input));
    }
}
