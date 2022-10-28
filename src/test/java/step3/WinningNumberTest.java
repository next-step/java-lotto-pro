package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {
    @Test
    @DisplayName("당첨번호 생성")
    public void WinningNumber_Create() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");
        assertThat(winningNumber.getWinningNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
    
    
}

