package step3.controller;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoBuyer;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.dto.LottoStatisticsResponseDto;
import step3.service.LottoServiceImpl;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
    private final LottoService lottoService = new LottoServiceImpl();
    private final LottoBuyer lottoBuyer;

    public LottoController() {
        this.lottoBuyer = createLottoBuyer();
    }

    public void play() {
        lottoService.buyLotto(lottoBuyer, registerManualLottoNumbers());

        buyLottoResult();

        statisticsResult(registerLatestLottoNumberAndBonus());
    }

    private void statisticsResult(WinningLotto winningLotto) {
        LottoStatisticsResponseDto lottoStatisticsResponseDto = lottoService.resultStatistics(lottoBuyer, winningLotto);

        ResultView.statisticsPrint(lottoStatisticsResponseDto);
    }

    private WinningLotto registerLatestLottoNumberAndBonus() {
        return InputView.readWinningLottoNumbers();
    }

    private void buyLottoResult() {
        ResultView.buyCountResultView(lottoBuyer);
        ResultView.buyLottoResultView(lottoBuyer);
    }

    private LottoBuyer createLottoBuyer() {
        int buyAmount = InputView.readLottoAmount();

        try {
            return lottoService.registerLottoBuyer(buyAmount);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return createLottoBuyer();
        }
    }

    private LottoNumbersBundle registerManualLottoNumbers() {
        int manualBuyCount = InputView.readLottoManualBuyCount();

        try {
            lottoBuyer.checkBuyAvailableQuantity(manualBuyCount);
            return InputView.readManualLottoNumbers(manualBuyCount);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return registerManualLottoNumbers();
        }
    }

}
