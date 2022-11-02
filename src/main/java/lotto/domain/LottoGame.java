package lotto.domain;

import java.util.List;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.factory.LottoNumberFactory;
import lotto.domain.lottonumber.factory.LottoNumberFactoryImpl;
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
    private LottoNumberFactory lottoNumberFactory;

    public LottoGame() {
        this.lottoNumberFactory = new LottoNumberFactoryImpl();
    }

    public void createPurchase(String purchase) {
        PurchaseFactory purchaseFactory = new PurchaseFactoryImpl(purchase);
        purChase = purchaseFactory.createPurchase();
    }

    public void createLottoNumbers() {
        lottoNumbers = new LottoNumbers(purChase, lottoNumberFactory);
    }

    public void createManualLottoNumbers(String manualLottoCount) {
        purChase.validateManualLottoCount(manualLottoCount);
        lottoNumbers = new LottoNumbers(purChase, lottoNumberFactory);
    }

    public void addManualLottoNumbers(List<String> manualLottoNumbers) {
        lottoNumbers.addManualLottoNumbers(manualLottoNumbers, lottoNumberFactory);
    }

    public String makeLottoNumbersResult() {
        return purChase.makeLottoNumbersResultHeader() + lottoNumbers.toString();
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
