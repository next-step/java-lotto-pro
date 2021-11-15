package lotto.service;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoService {
    public static void play() {
        BoughtMoney boughtMoney = new BoughtMoney(InputView.inputBoughtMoney());
        LottosCount lottosCount = new LottosCount(boughtMoney.getLottoCount(), InputView.inputManualLottoCount());
        ManualLottos manualLottos = new ManualLottos();
        manualLottos.createManualLottos(InputView.inputManualLottoNumbers(lottosCount.getManualLottoCount()));
        Lottos lottos = new Lottos(manualLottos);
        lottos.createAutoLottos(new ShuffledLottoNumbersStrategy(), lottosCount.getAutoLottoCount());

        ResultView.printLottoCount(lottosCount);
        ResultView.printLottoNumbers(lottos.getLottos());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(StringUtils.separate(InputView.inputWinningNumber()),
                                                                                    new BonusNumber(InputView.inputBonusNumber()));
        Map<LottoPrize, Integer> lottoResultMap = lottos.getWinningResult(winningLottoNumbers);
        ResultView.printWinningStatistics(lottoResultMap);
        ResultView.printProfitRate(lottos.calculateProfitRate(boughtMoney.getBoughtMoney()));
    }
}
