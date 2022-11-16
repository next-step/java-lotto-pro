package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoNumberDuplicateException;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @Test
    void 당첨_확인하기() {
        WinningLotto winLottoNumbers = new WinningLotto(new Lotto("4, 5, 6, 7, 8, 9"), new LottoNumber("3"));
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6")
                , new Lotto("2, 3, 4, 5, 6, 7")
                , new Lotto("2, 4, 5, 6, 7, 8")
                , new Lotto("4, 5, 6, 7, 10, 11")
                , new Lotto("3, 4, 5, 6, 7, 8")));

        Map<Rank, Integer> winners = lottos.findWinningLottos(winLottoNumbers);

        // 4, 5, 6
        assertThat(winners.get(Rank.FIFTH)).isEqualTo(1);
        // 4, 5, 6, 7
        assertThat(winners.get(Rank.FOURTH)).isEqualTo(2);
        // 4, 5, 6, 7, 8
        assertThat(winners.get(Rank.THIRD)).isEqualTo(1);
        // 4, 5, 6, 7, 8 bonus 3
        assertThat(winners.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 중복된_로또_예외() {
        assertThatThrownBy(() -> new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6")
                , new Lotto("1, 2, 3, 4, 5, 6"))))
                .isInstanceOf(LottoNumberDuplicateException.class);
    }
}
