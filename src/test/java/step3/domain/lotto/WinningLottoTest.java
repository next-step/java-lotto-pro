package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.LOTTO_NUMBER_DUPLICATE;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호에 보너스 번호가 포함되면 중복이므로 예외가 발생한다.")
    void notContainBonusLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1, 2, 3, 4, 5, 6");
                    BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(new LottoNumber(6));
                    new WinningLotto(winningLottoNumbers, bonusLottoNumber);
                })
                .withMessageContaining(LOTTO_NUMBER_DUPLICATE.getMessage());
    }
}
