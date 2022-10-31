package lotto.controller;

import lotto.domain.*;
import lotto.dto.LotteriesDto;
import lotto.dto.LottoResultDto;

public class LottoController {

    public LotteriesDto buyLotto(String userInput) {
        BuyAmount buyAmount = new BuyAmount(userInput);
        Lotteries lotteries = buyAmount.getLotteries(new AutoLottoCreator());
        return lotteries.getLotteriesDto();
    }

    public LottoResultDto lottoResult(LotteriesDto lotteriesDto, String winningNumbersUserInput, String buyAmountUserInput) {
        return new LottoResult(lotteriesDto.getLotteriesDomain(),
                new WinningNumbers(winningNumbersUserInput),
                new BuyAmount(buyAmountUserInput))
                .getLottoResultDto();
    }
}
