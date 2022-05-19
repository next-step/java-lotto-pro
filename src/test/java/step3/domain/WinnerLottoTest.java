package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

    final WinnerLotto winnerLotto = new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

    @Test
    void valid_당첨로또생성() {
        assertThat(winnerLotto).isEqualTo(new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10));
    }

    @Test
    void invalid_당첨로또생성_숫자개수초과() {
        assertThatThrownBy(() -> {
            new WinnerLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨순위확인_1등() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Ranking ranking = winnerLotto.matchRanking(lotto);
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    void 당첨순위확인_2등() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        Ranking ranking = winnerLotto.matchRanking(lotto);
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
}