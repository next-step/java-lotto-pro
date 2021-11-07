package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lottos 테스트")
class LottosTest {

    @Test
    @DisplayName("로또의 개수를 반환한다.")
    void size() {
        // given
        Lottos lottos = new Lottos(Arrays.asList(LottoGenerator.generate(), LottoGenerator.generate()));

        // when
        int size = lottos.size();

        // then
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 결과 리스트를 반환한다.")
    void getWinningResults() {
        // given
        Lottos lottos = Lottos.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        WinningResults winningResults = lottos.getWinningResults(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45));

        // then
        assertThat(winningResults).isEqualTo(WinningResults.from(WinningResult.FIRST, WinningResult.FIFTH));
    }
}
