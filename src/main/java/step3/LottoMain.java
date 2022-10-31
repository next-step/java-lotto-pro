package step3;

import step3.domain.*;
import step3.service.LottoBuyService;
import step3.service.LottoResultService;
import step3.service.LottoService;
import step3.strategy.AutoLottoNumberStrategy;
import step3.strategy.ConsoleLottoNumberStrategy;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;


public class LottoMain {
    public static void main(String[] args) {

        LottoBuyService buyService = new LottoBuyService(
                new LottoPayment(InputView.payLotto()), new AutoLottoNumberStrategy());

        OutputView.buyLottoCountPrint(buyService.getCount());

        List<Lotto> lottos = buyService.generateLottos();
        OutputView.printLottoNumbers(lottos);

        OutputView.printLastWeekWinningNumber();
        LottoService lottoService = new LottoService(lottos ,new ConsoleLottoNumberStrategy());

        LottoResult result = lottoService.matched();
        OutputView.printWinningStats(result);

        LottoResultService lottoResultService = new LottoResultService(result);
        LottoReturnRate lottoReturnRate = lottoResultService.calculateReturnRate(buyService.getCount());
        OutputView.printReturnRate(lottoReturnRate);
    }
}
