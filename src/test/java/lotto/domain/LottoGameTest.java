package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame game;

    @BeforeEach
    public void beforeEach() {
        game = new LottoGame(15000);
    }

    @Test
    void 로또_구매하기() {
        game.purchaseLotto();
    }

    @Test
    void 구매_로또_출력하기() {
        game.purchaseLotto();
        game.printMyLotto();
    }
}
