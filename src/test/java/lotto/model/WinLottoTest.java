package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinLottoTest {

    @Test
    @DisplayName("로또 번호는 6개의 수로 이루어져 있다.")
    void 로또당첨번호_보너스_예외_test() {
        //given
        int bonusNumber = 6;

        //when-then
        assertThatThrownBy(() -> new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("보너스번호가 지난당첨번호안에 중복이 될수 없습니다.");
    }
}
