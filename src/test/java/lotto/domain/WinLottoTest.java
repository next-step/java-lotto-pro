package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinLottoTest {

    @Test
    @DisplayName("당첨 번호에 존재하는 보너스 볼 예외 처리")
    void add_bonusNumber_already_exits_test() {
        assertThatThrownBy(() ->
                new WinLotto("1, 2, 3, 4, 5, 6", "1")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 볼 예외 처리")
    void add_bonusNumber_Not_Number_Type_test() {
        assertThatThrownBy(() ->
                new WinLotto("1, 2, 3, 4, 5, 6", "a")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
