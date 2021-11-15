package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private Lotto lotto;
    private LottoNumber lottoNumber;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoNumber = LottoNumber.of(7);
        winningLotto = new WinningLotto(lotto, lottoNumber);
    }

    @DisplayName("당첨번호 와 보너스 번호 객체 검증")
    @Test
    void winningLotto() {
        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7)));
    }

    @DisplayName("당첨번호와 로또를 비교하여 몇개 맞췄는지 출력하는 기능 검증")
    @Test
    void matchNumber() {
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(6, true));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(6, false));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.FIRST);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(5, true));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.SECOND);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(5, false));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.THIRD);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 5, 8, 23));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(4, false));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(4, true));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.FOURTH);

        lotto = new Lotto(Arrays.asList(1, 2, 5, 7, 23, 31));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(3, false));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(3, true));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.FIFTH);

        lotto = new Lotto(Arrays.asList(1, 2, 8, 11, 23, 31));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(2, false));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.valueOf(2, true));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.MISS);

        lotto = new Lotto(Arrays.asList(1, 8, 11, 23, 31, 32));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.MISS);

        lotto = new Lotto(Arrays.asList(7, 8, 11, 23, 31, 32));
        assertThat(winningLotto.matchRank(lotto)).isEqualTo(Rank.MISS);
    }

    @DisplayName("보너스 번호가 당첨번호에 있을때 에러")
    @Test
    void bonusExistError() {
        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BONUS_EXIST);
    }

    @DisplayName("null 일때 에러 검증")
    @Test
    void nullWinningLotto() {
        assertThatThrownBy(() -> {
            new WinningLotto(null, LottoNumber.of(6));
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);

        assertThatThrownBy(() -> {
            new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);

        assertThatThrownBy(() -> {
            new WinningLotto(null, null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);
    }
}

