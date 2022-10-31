package lotto.auto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    public void 숫자_6개_생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 당첨로또번호_저장_확인(int Expected) {
        String inputStr = "1, 2, 3, 4, 5, 6";
        LottoNumbers lottoNumbers = new LottoNumbers(inputStr);
        assertThat(lottoNumbers.getLottoNumbers()).contains(Expected);
    }
}
