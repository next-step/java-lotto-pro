package lotto.domain.lotto;

import lotto.status.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "45:45"}, delimiter = ':')
    @DisplayName("1~45사이의 숫자를 가진 LottoNumber 객체를 생성")
    void create_lotto_number(int number, int expect) {
        LottoNumber expectLottoNumber = new LottoNumber(expect);
        assertThat(new LottoNumber(number)).isEqualTo(expectLottoNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    @DisplayName("1~45사이의 숫자가 아닌 음수 , 45 초과의 숫자로 생성 시 IllegalArgumentException 발생")
    void create_lotto_number_argument_exception(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number)).withMessage(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"sdf", "k"})
    @DisplayName("숫자문자열이 아닌 문자열을 로또 번호로 생성시 IllegalArgumentException")
    void create_lotto_number_string_argument_exception(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number)).withMessage(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("숫자문자열이 null 이거나 empty인 경우 생성시 IllegalArgumentException")
    void create_lotto_number_string_null_or_empty_argument_exception(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number)).withMessage(ErrorStatus.INVALID_LOTTO_NUMBER.getMessage());
    }
}
