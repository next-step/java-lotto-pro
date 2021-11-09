package step3.controller;

import step3.common.exception.InvalidParamException;
import step3.domain.Amount;
import step3.domain.LottoService;
import step3.domain.WinningLotto;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoManualLottoNumbersRequestDto;
import step3.dto.LottoStatisticsRequestDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;
import step3.service.LottoServiceImpl;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {
    LottoService lottoService;

    public LottoController() {
        lottoService = new LottoServiceImpl();
    }

    public void play() {
        LottoStatisticsRequestDto lottoStatisticsRequestDto = new LottoStatisticsRequestDto();

        LottoBuyRequestDto lottoRequestDto = InputView.readLottoRequestDto();
        Amount amount = lottoRequestDto.getAmount();
        lottoStatisticsRequestDto.mapAmount(amount);

        int manualBuyCount = InputView.readManualLottoBuyCount();

        LottoBuyResponseDto manualLottoBuyResponseDto = manualLottoBuy(manualBuyCount);

        LottoBuyResponseDto lottoBuyResponseDto = lottoService.buyLotto(lottoRequestDto, new RandomLottoNumbers());

        ResultView.lottoBuyListPrint(manualLottoBuyResponseDto, lottoBuyResponseDto);

        LottoWinNumbersRequestDto lottoWinNumbersRequestDto = InputView.readLottoWinnerRequestDto(
            lottoRequestDto.getAmountValue());

        LottoBonusNumberRequestDto lottoBonusNumberRequestDto = getLottoBonusNumberRequestDto();

        lottoStatisticsRequestDto.mapWinningLotto(new WinningLotto(lottoWinNumbersRequestDto.getLottoNumbers(),
            lottoBonusNumberRequestDto.getBonusLottoNumber()));

        lottoStatisticsRequestDto.mapBuyLottoList(manualLottoBuyResponseDto.merge(lottoBuyResponseDto));

        LottoStatisticsResponseDto lottoStatisticsResponseDto = lottoService.getResultStatistics(
            lottoStatisticsRequestDto);

        ResultView.statisticsPrint(lottoStatisticsResponseDto, amount);
    }

    private LottoBuyResponseDto manualLottoBuy(int manualBuyCount) {
        try {
            LottoManualLottoNumbersRequestDto lottoManualLottoNumbersRequestDto = InputView.readLottoManualLottoNumbersRequestDto(
                manualBuyCount);

            return lottoService.buyLotto(lottoManualLottoNumbersRequestDto);
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return manualLottoBuy(manualBuyCount);
        }
    }

    private LottoBonusNumberRequestDto getLottoBonusNumberRequestDto() {
        try {
            return InputView.readLottoBonusNumberRequestDto();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return getLottoBonusNumberRequestDto();
        }
    }
}
