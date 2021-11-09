package step3.controller;

import java.util.List;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoBoughtListResponse;
import step3.dto.LottoStatisticsResponseDto;
import step3.service.LottoServiceImpl;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
    LottoService lottoService = new LottoServiceImpl();

    public LottoController() {
    }

    public void play() {
        registerUserLottoBuyAmount();

        registerManualLottoNumbers();

        registerAutoLottoNumbers();

        lottoBoughtResult();

        registerLatestLottoNumberAndBonus();

        resultStatistics();
    }

    public void registerUserLottoBuyAmount() {
        int buyAmount = InputView.readLottoAmount();

        try {
            lottoService.registerBuyAmount(buyAmount);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            registerUserLottoBuyAmount();
        }
    }

    public void registerManualLottoNumbers() {
        int manualBuyCount = InputView.readLottoManualBuyCount();

        try {
            List<NumbersStrategy> manualLottoNumbers = InputView.readManualLottoNumbers(manualBuyCount);
            lottoService.registerManualLottoBuy(manualLottoNumbers);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            registerManualLottoNumbers();
        }
    }

    public void registerAutoLottoNumbers() {
        lottoService.buyAutoLotto();
    }

    public void lottoBoughtResult() {
        LottoBoughtListResponse lottoBoughtListResponse = lottoService.getBoughtLottos();
        ResultView.boughtLottoView(lottoBoughtListResponse);
    }

    public void registerLatestLottoNumberAndBonus() {
        try {
            NumbersStrategy winningLottoNumber = InputView.readWinningLottoNumbers();
            lottoService.winningLottoNumber(winningLottoNumber, registerBonusNumber());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            registerLatestLottoNumberAndBonus();
        }
    }

    public int registerBonusNumber() {
        try {
            return InputView.readBonusNumber();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return registerBonusNumber();
        }
    }

    public void resultStatistics() {
        LottoStatisticsResponseDto result = lottoService.resultStatistics();
        ResultView.statisticsPrint(result);
    }

}
