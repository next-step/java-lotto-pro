package lotto.domain.number;

import static lotto.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

class WinningNumbersTest {
    @DisplayName("6개의 번호와 보너스 번호를 입력받는 정적팩토리 메서드를 이용하여 당첨번호 객체를 생성한다.")
    @Test
    void createTest() {
        assertThat(WinningNumbers.of(LOTTO_NUMBER_1_2_3_4_5_6, 7)).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("보너스번호가 로또번호 6개에 포함되면 예외를 던진다.")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> WinningNumbers.of(LOTTO_NUMBER_1_2_3_4_5_6, 6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
