package lotto.controller;

import lotto.domain.*;
import lotto.dto.*;

import java.util.List;

public class LottoController {

    public LotteriesDto buyLotto(String userInput) {
        BuyAmount buyAmount = new BuyAmount(userInput);
        Lotteries lotteries = buyAmount.getLotteries(new AutoLottoCreator());
        return lotteries.getLotteriesDto();
    }

    public WinningNumbersDto readWinningNumbers(String readUserInput) {
        return new WinningNumbersDto(new WinningNumbers(readUserInput));
    }

    public WinningNumbersDto readBonusNumber(WinningNumbersDto winningNumbersDto, String readUserInput) {
        List<Integer> winningNumbers = winningNumbersDto.getWinningNumbers();
        return new WinningNumbersDto(new WinningNumbers(winningNumbers, new BonusNumber(readUserInput)));
    }

    public LottoResultDto lottoResult(LottoResultRequestDto lottoResultRequestDto) {
        return new LottoResult(lottoResultRequestDto.getLotteriesDto().getLotteriesDomain(),
                lottoResultRequestDto.getWinningNumbers().getWinningNumbersDomain(),
                new BuyAmount(lottoResultRequestDto.getBuyAmountUserInput()))
                .getLottoResultDto();
    }

}
