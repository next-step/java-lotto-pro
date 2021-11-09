package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 생성하여 toString 및 size로 검증.")
    @Test
    void lottoCreate() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
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

    @DisplayName("로또 번호가 맞지 않을때 나오는 에러")
    @Test
    void lottoSizeUnmatchedError() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_UNMATCHED);

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_UNMATCHED);
    }
}
