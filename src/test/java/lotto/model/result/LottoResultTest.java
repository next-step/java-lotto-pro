package lotto.model.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.factory.LottoTestFactory;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;
import lotto.model.purchase.PurchaseLotto;
import lotto.model.winning.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("구입한 로또의 수익률을 계산")
    void 구입한_로또의_수익률을_계산한다() {
        LottoResult lottoResult = generateLottoResult();
        Money purchaseMoney = new Money(20_000);

        assertEquals(lottoResult.winningRate(purchaseMoney), 0.5);
    }

    private LottoResult generateLottoResult() {
        List<Lotto> lottoList = new LottoTestFactory().generateAuto(2);

        PurchaseLotto purchaseLotto = new PurchaseLotto(lottoList);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList("1", "2", "3", "7", "8", "9"), "10");

        return purchaseLotto.rankMatch(winningLotto);
    }

}
