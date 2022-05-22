package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호 비정상 값 검증")
    public void checkNotValid() {
        LottoNumbersInput lottoNumbersInput = new LottoNumbersInput("1, 2, 3, 4, 5, 6");
        WinningNumber winningNumber = new WinningNumber(lottoNumbersInput);
        assertThatThrownBy(() -> {new BonusNumber(2, winningNumber);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}
