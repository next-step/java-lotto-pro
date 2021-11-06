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
        int quantity = 5;
        Lottos lottos = Lottos.fromQuantity(quantity);

        // when
        int size = lottos.size();

        // then
        assertThat(size).isEqualTo(quantity);
    }

    @Test
    @DisplayName("당첨 결과 리스트를 반환한다.")
    void getWinResults() {
        // given
        Lottos lottos = Lottos.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // when
        WinResults winResults = lottos.getWinResults(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // then
        assertThat(winResults).isEqualTo(WinResults.from(WinResult.FIRST, WinResult.FIFTH));
    }
}
