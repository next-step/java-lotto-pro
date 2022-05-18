import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또_번호_클래스_생성() {
        LottoNumber lottoNumber = new LottoNumber(30);

        assertThat(lottoNumber).asString().contains("30");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 77})
    void 로또_번호_클래스_생성_예외(Integer input) {
        assertThatThrownBy(() -> new LottoNumber(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumber.LOTTO_NUMBER_OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
    }

    @Test
    void 보너스_번호_생성() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        LottoNumber lottoNumber = new LottoNumber("7", winningNumbers);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(7));

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호_생성_예외(String input) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThatThrownBy(() -> new LottoNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
