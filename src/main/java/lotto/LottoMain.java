package lotto;

import static lotto.domain.LottoPayment.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.strategy.AutoLottoNumberStrategy;
import lotto.strategy.ConsoleLottoNumberStrategy;
import lotto.strategy.LottoNumberStrategy;

public class LottoMain {
    public static void main(String[] args) {

        LottoNumberStrategy buyingLottoStrategy = new AutoLottoNumberStrategy();
        LottoNumberStrategy winningLottoStrategy = new ConsoleLottoNumberStrategy();

        LottoService lottoService = new LottoService(buyingLottoStrategy, winningLottoStrategy);
        LottoPayment lottoPayment = lottoService.buyLotto(payLotto());
        buyLottoCountPrint(lottoPayment.getLottoCount());

        ManualLottoCount manualLottoCount = lottoService.generateManualLottoCount(lottoPayment);
        printManualLottoInput(manualLottoCount.getCount());
        BuyingLottoGroup buyingLottoGroup = lottoService.generateBuyingLottoGroup(lottoPayment.getLottoCount(),
                manualLottoCount.getCount());
        printBuyLottoCount(lottoPayment.getLottoCount() - manualLottoCount.getCount(),
                manualLottoCount.getCount());
        printLottoNumbers(buyingLottoGroup.getLottos());

        printLastWeekWinningNumber();
        Lotto basicLotto = lottoService.generateWinningBasicLotto();
        LottoNumber bonusNumber = lottoService.generateWinningBonusNumber();

        WinningLotto winningLotto = WinningLotto.create(basicLotto, bonusNumber);
        LottoResult result = lottoService.getMatchingResultBuyingLottoGroupAndWinningLotto(
                buyingLottoGroup, winningLotto);

        printWinningStats(result);
        printReturnRate(new LottoReturnRate(result.calculateWinningMoney(), lottoPayment.getLottoCount() * PRICE));
    }
}
