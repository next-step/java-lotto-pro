package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @Test
    void 로또를_구매할_때마다_지불_금액_차감() {
        LottoGame lottoGame = new LottoGame(10000);
        for (int i = 0; i < 5; i++) {
            lottoGame.minusBalance();
        }
        assertThat(lottoGame.getBalance()).isEqualTo(5000);
    }

    @Test
    void 지불_금액_보다_더_많은_개수를_구매하는_경우() {
        LottoGame lottoGame = new LottoGame(500);
        assertThatThrownBy(lottoGame::minusBalance).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 만원을_지불한_경우_로또_개수_테스트() {
        assertThat(new LottoGame(10000).getAutoPurchasableCount()).isEqualTo(10);
    }

    @Test
    void 로또_1개_구매_테스트() {
        assertThat(new LottoGame(1000).autoPurchaseLotto(1).size()).isEqualTo(1);
    }
}
