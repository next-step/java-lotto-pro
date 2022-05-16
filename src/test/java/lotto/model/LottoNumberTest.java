package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 번호가 1~45 사이가 아닌 경우 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0","46"})
    void not_lotto_number(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumber(number))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"%$","en"})
    void not_number(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new LottoNumber(number))
                .withMessage("[ERROR] 숫자가 아닙니다.");
    }

}
