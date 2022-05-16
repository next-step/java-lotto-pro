package lotto.model.purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.factory.LottoTestFactory;
import lotto.model.lotto.Lotto;
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
        List<Lotto> lottoList = new LottoTestFactory().generateAuto(2);

        PurchaseLotto purchaseLotto = new PurchaseLotto(lottoList);
        WinningLotto winningLotto = new WinningLotto(new String[]{"1", "2", "3", "7", "8", "9"});

        return purchaseLotto.rankMatch(winningLotto);
    }

}
