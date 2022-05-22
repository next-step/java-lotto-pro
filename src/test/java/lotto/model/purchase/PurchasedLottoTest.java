package lotto.model.purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.factory.LottoTestFactory;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.type.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {

    @Test
    @DisplayName("구입한 로또가 몇등인지 확인한다.")
    void 구입한_로또가_당첨인지_확인() {
        LottoResult lottoResult = generateLottoResult();

        assertEquals(lottoResult.getLottoResultMap().get(LottoRank.THREE), 2);
    }

    private LottoResult generateLottoResult() {
        List<Lotto> autoList = new LottoTestFactory().generateAuto(1);
        List<Lotto> manualList = new LottoTestFactory().generateAuto(1);

        PurchaseLotto purchaseLotto = new PurchaseLotto(autoList, manualList);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 7, 8, 9), 10);

        return purchaseLotto.rankMatch(winningLotto, new Money(14000));
    }

}
