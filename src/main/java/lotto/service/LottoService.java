package lotto.service;

import lotto.domain.*;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoService {
    public static void play() {
        int boughtMoney = new BoughtMoney(InputView.inputBoughtMoney()).getBoughtMoney();
        int totalCount = LottoServiceCalculator.getLottoCount(boughtMoney);
        ManualLottos manualLottos = new ManualLottos(new ManualLottosCount(totalCount, InputView.inputManualLottoCount()));
        int autoLottoCount = totalCount - manualLottos.getManualLottosCount();
        manualLottos.createManualLottos(InputView.inputManualLottoNumbers(manualLottos.getManualLottosCount()));
        Lottos lottos = new Lottos(manualLottos);
        lottos.createAutoLottos(new ShuffledLottoNumbersStrategy(), totalCount - manualLottos.getManualLottosCount());

        ResultView.printLottoCount(manualLottos.getManualLottosCount(), autoLottoCount);
        ResultView.printLottoNumbers(lottos.getLottos());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(StringUtils.separate(InputView.inputWinningNumber()),
                                                                                    new BonusNumber(InputView.inputBonusNumber()));
        Map<LottoPrize, Integer> lottoResultMap = lottos.createLottosResult(winningLottoNumbers);
        ResultView.printWinningStatistics(lottoResultMap);
        ResultView.printProfitRate(LottoServiceCalculator.calculateProfitRate(lottoResultMap, boughtMoney));
    }
}
