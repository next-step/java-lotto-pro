package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호 입력 확인")
    void 당첨_번호_입력() {
        LottoNumbers numbers = LottoNumbers.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6));
        Bonus bonus = Bonus.from(7);
        assertThat(WinningLotto.of(numbers, bonus).getWinningNumbers()).isEqualTo(numbers);
        assertThat(WinningLotto.of(numbers, bonus).getBonus()).isEqualTo(bonus);
    }

}