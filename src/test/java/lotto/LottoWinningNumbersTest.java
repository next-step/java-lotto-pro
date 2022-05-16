package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoWinningNumbers;

@DisplayName("LottoWinningNumbers 클래스")
public class LottoWinningNumbersTest {
    @DisplayName("숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void isNotNumberThenThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new LottoWinningNumbers("a,g,2,3,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1이상 45이하의 숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void isNotRangeOneToFourtyFiveThenThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new LottoWinningNumbers("0,4,5,3,4,82"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자의 갯수가 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void sizeLessThanSixThenThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new LottoWinningNumbers("1,2,5,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 숫자가 중복이 존재하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void cannotBeDuplicated() {
        assertThatThrownBy(() -> new LottoWinningNumbers("1,1,5,3,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
