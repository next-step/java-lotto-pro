package lotto.domain;

import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    void 로또_구매하기() {
        LottoGame game = new LottoGame(15000);
        game.purchaseLotto();
    }

    @Test
    void 구매_로또_출력하기() {
        LottoGame game = new LottoGame(15000);
        game.purchaseLotto();
        game.printMyLotto();
    }
}
