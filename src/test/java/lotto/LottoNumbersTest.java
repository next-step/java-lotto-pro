package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 당첨로또번호_저장_확인(int Expected) {
        String inputStr = "1, 2, 3, 4, 5, 6";
        LottoNumbers lottoNumbers = new LottoNumbers(inputStr);
        assertThat(lottoNumbers.getLottoNumbers()).contains(LottoNumber.of(Expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1, 2, 4, 5, 6"})
    public void 당첨로또번호_예외_확인(String inputStr) {
        assertThatThrownBy(() -> new LottoNumbers(inputStr)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 숫자_예외_테스트(int input) {
        assertThatThrownBy(() -> new LottoNumbers().add(LottoNumber.of(input))).isInstanceOf(IllegalArgumentException.class);
    }
}
