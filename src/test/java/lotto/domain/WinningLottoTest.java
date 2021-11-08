package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호는 당첨번호에 포함될 수 없다")
    @Test
    void validateDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            LottoNumber.valueOf(1))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨번호에 포함되지 않으면 정상적으로 객체가 생성된다")
    @Test
    void createWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
        assertNotNull(winningLotto);
    }

    @DisplayName("1등부터 5등까지의 결과를 확인한다")
    @Test
    void createWinningRank() {
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusNumber);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)))).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)))).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)))).isEqualTo(Rank.FIFTH);
        assertThat(winningLotto.createWinningRank(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)))).isEqualTo(Rank.MISS);
    }
}
