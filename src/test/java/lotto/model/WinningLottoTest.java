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

    @DisplayName("당첨번호와 로또를 비교하여 몇개 맞췄는지 출력하는 기능 검증")
    @Test
    void matchNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        assertThat(winLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(6, true));
        assertThat(winLotto.matchRank(lotto)).isEqualTo(Rank.FIRST);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        winLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        assertThat(winLotto.matchRank(lotto)).isEqualTo(Rank.SECOND);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        winLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(8));
        assertThat(winLotto.matchRank(lotto)).isEqualTo(Rank.THIRD);
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

