package lotto.controller;

import lotto.domain.Lotteries;
import lotto.service.LottoService;
import lotto.view.BuyAmountInputView;
import lotto.view.LottoResultView;
import lotto.view.WinningNumberInputView;

public class LottoController {

    LottoService lottoService = new LottoService();
    LottoResultView lottoResultView = new LottoResultView();

    public int readBuyAmount() {
        BuyAmountInputView buyAmountReader = new BuyAmountInputView();
        return Integer.parseInt(buyAmountReader.readBuyAmount());
    }

    public Lotteries buyLotto(int buyAmount) {
        Lotteries lotteries = lottoService.buyLotto(buyAmount);
        lottoResultView.write(lotteries);
        return lotteries;
    }

    public int[] readWinningNumbers() {
        WinningNumberInputView winningNumberReader = new WinningNumberInputView();
        return winningNumberReader.readWinningNumbers();
    }

    public void lottoResult(Lotteries lotteries, int[] winningNumbers, int buyAmount) {
        lottoResultView.write("당첨 통계\n---------\n" + lottoService.lottoResult(lotteries,winningNumbers,buyAmount));
    }
}
