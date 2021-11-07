package step3.controller;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoService;
import step3.domain.strategy.numbers.RandomLottoNumbers;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
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
        // 사용자에게 구매할 돈을입금 받는다.
        LottoBuyRequestDto lottoRequestDto = InputView.readLottoRequestDto();

        // 로또를 구매한다.
        LottoBuyResponseDto lottoBuyResponseDto = lottoService.buyLotto(lottoRequestDto, new RandomLottoNumbers());

        // 총몇개를 구입했는지 출력한다.
        // 구매한 로또를 출력한다.
        ResultView.lottoBuyListPrint(lottoBuyResponseDto);

        // 지난 주 당첨번호 받기
        LottoWinNumbersRequestDto lottoWinNumbersRequestDto = InputView.readLottoWinnerRequestDto(
            lottoRequestDto.getAmountValue());

        // 보너스 볼을 입력해 주세요.
        LottoBonusNumberRequestDto lottoBonusNumberRequestDto = getLottoBonusNumberRequestDto(
            lottoWinNumbersRequestDto);

        // 당첨통계를출력한다.(로또 당첨 갯수와 수익률)
        ResultView.statisticsPrint(
            lottoService.getResultStatistics(
                lottoWinNumbersRequestDto,
                lottoBonusNumberRequestDto
            )
        );
    }

    private LottoBonusNumberRequestDto getLottoBonusNumberRequestDto(
        LottoWinNumbersRequestDto lottoWinNumbersRequestDto) {
        try {
            LottoBonusNumberRequestDto lottoBonusNumberRequestDto = InputView.readLottoBonusNumberRequestDto();
            validBonus(lottoWinNumbersRequestDto, lottoBonusNumberRequestDto);

            return lottoBonusNumberRequestDto;
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());
            return getLottoBonusNumberRequestDto(lottoWinNumbersRequestDto);
        }
    }

    private void validBonus(LottoWinNumbersRequestDto lottoWinNumbersRequestDto,
        LottoBonusNumberRequestDto lottoBonusNumberRequestDto) {
        lottoWinNumbersRequestDto.validContain(lottoBonusNumberRequestDto.getBonusLottoNumber());
    }
}
