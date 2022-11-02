package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.WinningBonusNumber;

public class WinningBonusNumberTest {
    private static Lotto winningNumber;
    @BeforeAll
    static void beforeAll() {
        winningNumber = new Lotto("1,2,3,4,5,6");
    }
    
    @Test
    @DisplayName("보너스 번호 생성")
    public void WinningBonusNumber_Create() {
        WinningBonusNumber winningBonusNumber = new WinningBonusNumber("1,2,3,4,5,6","7");
        assertThat(winningBonusNumber).isEqualTo(winningBonusNumber);
        assertThat(winningBonusNumber.getWinningNumber()).isEqualTo(winningNumber.getWinningNumbers());
    }
    
    @Test
    @DisplayName("보너스 번호 0~45의 숫자 예외처리")
    public void WinningBonusNumber_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningBonusNumber("1,2,3,4,5,6","-1"))
                .withMessageContaining("");
    }

}
