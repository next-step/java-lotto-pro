package lotto.domain.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

    @Test
    @DisplayName("로또번호와 당첨번호를 비교하여 일치한 갯수를 확인")
    void matchNumber() {
        assertThat(winningNumber.matchNumber(Arrays.asList(1, 2, 3, 4, 5, 6).iterator())).isEqualTo(6);
        assertThat(winningNumber.matchNumber(Arrays.asList(7, 8, 9, 10, 11, 12).iterator())).isEqualTo(0);
    }
}
