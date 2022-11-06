package lotto;

import static lotto.domain.LottoPayment.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.*;
import lotto.io.InputUtils;
import lotto.service.LottoService;
import lotto.strategy.AutoLottoNumberStrategy;
import lotto.strategy.ConsoleLottoNumberStrategy;
import lotto.strategy.LottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {

        LottoNumberStrategy buyingLottoStrategy = new AutoLottoNumberStrategy();
        LottoNumberStrategy winningLottoStrategy = new ConsoleLottoNumberStrategy();

        LottoService lottoService = new LottoService(buyingLottoStrategy, winningLottoStrategy);
        LottoPayment lottoPayment = lottoService.buyLotto(payLotto());
        buyLottoCountPrint(lottoPayment.getLottoCount());

        ManualLottoCount manualLottoCount = ManualLottoCount.create(buyManualLotto(),
                lottoPayment.getLottoCount());
        printManualLottoInput();
        BuyingLottoGroup buyingLottoGroup = lottoService.generateBuyingLottoGroup(lottoPayment.getLottoCount(),
                manualLottoCount.getCount());
        printBuyLottoCount(lottoPayment.getLottoCount() - manualLottoCount.getCount(),
                manualLottoCount.getCount());
        printLottoNumbers(buyingLottoGroup.getLottos());

        printLastWeekWinningNumber();
        Lotto basicLotto = lottoService.generateWinningBasicLotto();
        LottoNumber bonusNumber = lottoService.generateWinningBonusNumber(inputBonusNumber());

        WinningLotto winningLotto = WinningLotto.create(basicLotto, bonusNumber);
        LottoResult result = lottoService.getMatchingResultBuyingLottoGroupAndWinningLotto(
                buyingLottoGroup, winningLotto);

        printWinningStats(result);
        printReturnRate(new LottoReturnRate(result.calculateWinningMoney(), lottoPayment.getLottoCount() * PRICE));
    }
}
