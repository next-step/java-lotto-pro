package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lottos 테스트")
class LottosTest {

    @Test
    @DisplayName("로또의 개수를 반환한다.")
    void getQuantity() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);
        Lottos lottos = LottosGenerator.generate(purchaseAmount, Lottos.EMPTY);

        // when
        int size = lottos.getTotalQuantity();

        // then
        assertThat(size).isEqualTo(purchaseAmount.getQuantity());
    }

    @Test
    @DisplayName("당첨 결과 리스트를 반환한다.")
    void getWinningResults() {
        // given
        Lottos lottos = Lottos.of(
                Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.from(Arrays.asList(4, 5, 6, 7, 8, 9)),
                Lotto.from(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        WinningLotto winningLotto = new WinningLotto(
                Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45));

        // when
        WinningResults winningResults = lottos.getWinningResults(winningLotto);

        // then
        assertThat(winningResults).isEqualTo(WinningResults.from(WinningResult.FIRST, WinningResult.FIFTH));
    }
}
