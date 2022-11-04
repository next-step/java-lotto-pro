package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @Test
    void 만원을_지불한_경우_로또_개수_테스트() {
        assertThat(new LottoGame(10000, new LottoNumberAutoGenerator()).getPurchaseCount()).isEqualTo(10);
    }

    @Test
    void 로또_1개_구매_테스트() {
        assertThat(new LottoGame(1000, new LottoNumberAutoGenerator()).purchaseLotto(1).size()).isEqualTo(1);
    }
}
