package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호 포함 여부 검증")
    public void checkNotValid() {
        LottoNumbersInput lottoNumbersInput = new LottoNumbersInput("9, 11, 15, 22, 33, 45");
        assertThat(new WinningNumber(lottoNumbersInput).contains(9)).isTrue();
        assertThat(new WinningNumber(lottoNumbersInput).contains(new LottoNo(15))).isTrue();
    }
}
