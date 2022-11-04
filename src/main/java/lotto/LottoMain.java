package lotto;

import static lotto.domain.LottoPayment.*;

import lotto.domain.*;
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
        LottoPayment lottoPayment = lottoService.buyLotto(InputView.payLotto());
        OutputView.buyLottoCountPrint(lottoPayment.getLottoCount());

        BuyingLottoGroup buyingLottoGroup = lottoService.generateBuyingLottoGroup(lottoPayment.getLottoCount());
        OutputView.printLottoNumbers(buyingLottoGroup.getLottos());

        OutputView.printLastWeekWinningNumber();
        Lotto basicLotto = lottoService.generateWinningBasicLotto();
        LottoNumber bonusNumber = lottoService.generateWinningBonusNumber(InputView.inputBonusNumber());

        WinningLotto winningLotto = WinningLotto.create(basicLotto, bonusNumber);
        LottoResult result = lottoService.getMatchingResultBuyingLottoGroupAndWinningLotto(
                buyingLottoGroup, winningLotto);

        OutputView.printWinningStats(result);
        OutputView.printReturnRate(new LottoReturnRate(result.calculateWinningMoney(), lottoPayment.getLottoCount() * PRICE));
    }
}
