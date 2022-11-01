package lottoauto;

import lottoauto.domain.*;
import lottoauto.service.LottoBuyService;
import lottoauto.service.LottoResultService;
import lottoauto.service.LottoService;
import lottoauto.strategy.AutoLottoNumberStrategy;
import lottoauto.strategy.ConsoleLottoNumberStrategy;
import lottoauto.view.InputView;
import lottoauto.view.OutputView;

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
