package lotto.domain;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.lottonumber.purchase.factory.PurchaseFactory;
import lotto.domain.lottonumber.purchase.factory.PurchaseFactoryImpl;
import lotto.domain.matcher.LottoNumberMatcher;
import lotto.domain.result.DefaultLottoResult;

public class LottoGame {

    private Purchase purChase;
    private LottoNumbers lottoNumbers;
    private LottoNumberMatcher lottoNumberMatcher;

    public void createPurchase(String purchase) {
        PurchaseFactory purchaseFactory = new PurchaseFactoryImpl(purchase);
        purChase = purchaseFactory.createPurchase();
    }

    public void createLottoNumbers() {
        lottoNumbers = new LottoNumbers(purChase);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public void createLottoNumberMatcher(String readWinningNumber) {
        lottoNumberMatcher = new LottoNumberMatcher(lottoNumbers, readWinningNumber);
    }

    public DefaultLottoResult result() {
        return lottoNumberMatcher.result();
    }

    public String makeProfitMargin() {
        return lottoNumberMatcher.makeProfitMargin(purChase);
    }
}
