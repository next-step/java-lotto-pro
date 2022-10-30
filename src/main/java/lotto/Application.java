package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotteries;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        int buyAmount = lottoController.readBuyAmount();
        Lotteries lotteries = lottoController.buyLotto(buyAmount);
        int[] winningNumbers = lottoController.readWinningNumbers();
        lottoController.lottoResult(lotteries, winningNumbers, buyAmount);
    }
}
