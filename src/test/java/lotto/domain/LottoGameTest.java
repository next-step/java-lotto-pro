package lotto.domain;

import org.junit.jupiter.api.Test;

class LottoGameTest {
    @Test
    public void 로또_구매하기() {
        LottoGame game = new LottoGame();
        game.purchaseLotto(new Money(5000));
    }
}
