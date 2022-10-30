package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.WinningBonusNumber;
import step3.domain.WinningNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningBonusNumberTest {
    @Test
    @DisplayName("보너스 번호 생성")
    public void WinningBonusNumber_Create() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber(winningNumber,"7");
        assertThat(winningBonusNumber).isEqualTo(winningBonusNumber);
        assertThat(winningBonusNumber.getWinningNumber()).isEqualTo(winningNumber.getWinningNumbers());
    }

}
