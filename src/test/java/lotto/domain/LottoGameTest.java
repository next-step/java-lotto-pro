package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoGameTest {
    @Test
    public void 로또_구매하기() {
        LottoGame game = new LottoGame(5000);
        game.purchaseLotto();
    }

    @Test
    public void 구매_로또_출력하기() {
        LottoGame game = new LottoGame(5000);
        game.purchaseLotto();
        game.printMyLotto();
    }

    @Test
    public void 로또_당첨통계_출력하기() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 7, 8),
                new Lotto(1, 2, 3, 7, 8, 9));
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottoList);
        LottoGame game = new LottoGame(purchasedLottos, "1, 2, 3, 4, 5, 6");
        game.showLottoStatistics();
    }

    @Test
    public void 로또_총_수익률_출력하기() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6));
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottoList);
        LottoGame game = new LottoGame(new Money(1000), purchasedLottos, "1, 2, 3, 4, 5, 6");
        game.showLottoStatistics();
        game.showLottoProfit();
    }
}
