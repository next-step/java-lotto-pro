package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("당첨번호 와 보너스 번호 객체 검증")
    @Test
    void winningLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)));
    }

    @DisplayName("보너스 번호가 당첨번호에 있을때 에러")
    @Test
    void bonusExistError() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_EXIST);
    }
}

