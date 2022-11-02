package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.WinningBonusNumber;

public class ValidationUtilsTest {
    @Test
    @DisplayName("숫자 아닌경우 예외처리")
    public void ValidationUtils_parseInt_exception() {
        assertThat(ValidationUtils.parseInt("1")).isEqualTo(1);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ValidationUtils.parseInt("a"))
                .withMessageContaining("1부터 45까지의 숫자");
    }
    
    @Test
    @DisplayName("당첨번호 0~45 이외의 숫자 예외처리")
    public void WinningNumber_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto("1,2,-1,4,5,7"))
                .withMessageContaining("1부터 45까지의 숫자");
    }
    
    @Test
    @DisplayName("보너스 숫자 0~45 이외의 숫자 예외처리")
    public void WinningBonusNumber_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningBonusNumber("1,2,3,4,5,6","-1"))
                .withMessageContaining("1부터 45까지의 숫자");
    }

}
