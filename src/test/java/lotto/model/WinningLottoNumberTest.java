package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoNumberTest {

    @Test
    @DisplayName("생성한 당첨 번호 객체 검증")
    void verifyWinningLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(9);

        assertThat(new WinningLottoNumber(lottoNumber, number)).isNotNull();
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복되면 IllegalArgumentException이 발생")
    void duplicateBonusNumberWithLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of("1,2,3,4,5,6"));
        Number number = Number.of(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumber(lottoNumber, number))
                .withMessage("당첨 번호와 보너스 번호가 중복됩니다.");
    }
}
