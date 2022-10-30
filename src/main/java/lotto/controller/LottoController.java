package lotto.controller;

import lotto.domain.Lotteries;
import lotto.service.LottoService;
import lotto.view.BuyAmountReader;
import lotto.view.WinningNumberReader;

public class LottoController {

    LottoService lottoService = new LottoService();

    public int readBuyAmount() {
        BuyAmountReader buyAmountReader = new BuyAmountReader();
        return Integer.parseInt(buyAmountReader.readBuyAmount());
    }

    public Lotteries buyLotto(int buyAmount) {
        Lotteries lotteries = lottoService.buyLotto(buyAmount);
        System.out.println(lotteries);
        return lotteries;
    }

    public int[] readWinningNumbers() {
        WinningNumberReader winningNumberReader = new WinningNumberReader();
        return winningNumberReader.readWinningNumbers();
    }

    public void lottoResult(Lotteries lotteries, int[] winningNumbers, int buyAmount) {
        System.out.println("당첨 통계\n---------");
        System.out.println(lottoService.lottoResult(lotteries,winningNumbers,buyAmount));
    }
}
