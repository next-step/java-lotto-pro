package lotto.domain;

import org.junit.jupiter.api.Test;

class LottoGameTest {
    @Test
    public void 로또_구매하기() {
        LottoGame game = new LottoGame(5000);
        game.purchaseLotto();
    }
}
