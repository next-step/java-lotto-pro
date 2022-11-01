package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.WinningLottoNumber;

class WinningLottoNumberTest {

    @Test
    @DisplayName("당첨번호와 보너스번호가 중복될 때 에러 발생 테스트")
    void validDuplicateNumber() {
        String winningNumbers = "1, 11, 31, 45, 25, 36";
        int bonusNumber = 36;
        assertThatThrownBy(() -> new WinningLottoNumber(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨번호와 보너스 번호는 중복될 수 없습니다.");
    }
}
