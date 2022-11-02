package lotto;

import lotto.domain.*;
import lotto.service.LottoBuyService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.strategy.AutoLottoNumberStrategy;
import lotto.strategy.ConsoleLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoMain {
    public static void main(String[] args) {

        LottoBuyService buyService = new LottoBuyService(
                new LottoPayment(InputView.payLotto()), new AutoLottoNumberStrategy());

        OutputView.buyLottoCountPrint(buyService.getCount());

        List<Lotto> lottos = buyService.generateLottos();
        OutputView.printLottoNumbers(lottos);

        OutputView.printLastWeekWinningNumber();
        LottoService lottoService = new LottoService(new ConsoleLottoNumberStrategy());
        Lotto winning = lottoService.generateWinningLotto();

        LottoResult result = lottoService.matched(lottos, winning);
        OutputView.printWinningStats(result);

        LottoResultService lottoResultService = new LottoResultService(result);
        LottoReturnRate lottoReturnRate = lottoResultService.calculateReturnRate(buyService.getCount());
        OutputView.printReturnRate(lottoReturnRate);
    }
}
