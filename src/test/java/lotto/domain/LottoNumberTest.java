package lotto.domain;

import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

    @Test
    @DisplayName("숫자를 통해 로또 번호 생성")
    void createLottoNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    @DisplayName("로또 번호가 1~45 사이의 숫자가 아닐 시에 InvalidLottoNumberException 발생")
    void throwInvalidLottoNumberExceptionTest(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("같은 숫자의 로또 번호는 같은 객체")
    void lottoNumberEqualTest(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(input));
    }
}