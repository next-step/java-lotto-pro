package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 예외테스트_기존숫자_6개와_보너스숫자는_중복되지_않는다() {
        Lotto lotto = new Lotto(new int[]{1, 2, 3, 4,5 ,6});
        int bonusNumber = 3;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}