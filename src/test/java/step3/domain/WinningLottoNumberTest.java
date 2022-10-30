package step3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WinningLottoNumberTest {
    @Test
    void 당첨번호와_보너스번호는_중복될_수_없다() {
        String receiveWinningNumbers = "1, 2, 3, 4, 5, 6";
        int receiveBonusNumber = 6;
        assertThatThrownBy(() -> new WinningLottoNumber(receiveWinningNumbers, receiveBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호와 보너스 번호는 중복될 수 없습니다.");
    }
}
