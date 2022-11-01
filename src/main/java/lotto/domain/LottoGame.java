package lotto.domain;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.lottonumber.purchase.factory.PurchaseFactory;
import lotto.domain.lottonumber.purchase.factory.PurchaseFactoryImpl;
import lotto.domain.matcher.LottoNumberMatcher;
import lotto.domain.result.DefaultLottoResult;
import lotto.domain.winningnumber.WinningNumber;
import lotto.domain.winningnumber.factory.WinningNumberFactory;
import lotto.domain.winningnumber.factory.WinningNumberOnlyFactory;

public class LottoGame {

    private Purchase purChase;
    private LottoNumbers lottoNumbers;
    private WinningNumber winningNumber;
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

    public void createWinningNumber(String readWinningNumber) {
        WinningNumberFactory winningNumberFactory = new WinningNumberOnlyFactory(readWinningNumber);
        winningNumber = winningNumberFactory.createWinningNumber();
    }

    public void createLottoNumberMatcher() {
        lottoNumberMatcher = new LottoNumberMatcher(lottoNumbers, winningNumber);
    }

    public void createLottoNumberMatcherWithBonus(String bonus) {
        lottoNumberMatcher = new LottoNumberMatcher(lottoNumbers, winningNumber.createWinningNumberWithBonus(bonus));
    }

    public DefaultLottoResult result() {
        return lottoNumberMatcher.result();
    }

    public String makeProfitMargin() {
        return lottoNumberMatcher.makeProfitMargin(purChase);
    }
}
