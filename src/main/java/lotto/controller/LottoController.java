package lotto.controller;

import lotto.domain.Lotteries;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {

    LottoService lottoService = new LottoService();
    LottoInputView lottoInputView = new LottoInputView();
    LottoResultView lottoResultView = new LottoResultView();

    public int readBuyAmount() {
        return lottoService.readBuyAmount(lottoInputView.readUserInput("구입금액을 입력해 주세요."));
    }

    public Lotteries buyLotto(int buyAmount) {
        Lotteries lotteries = lottoService.buyLotto(buyAmount);
        lottoResultView.write(lotteries);
        return lotteries;
    }

    public int[] readWinningNumbers() {
        return lottoService.readWinningNumbers(lottoInputView.readUserInput("지난 주 당첨 번호를 입력해 주세요."));
    }

    public void lottoResult(Lotteries lotteries, int[] winningNumbers, int buyAmount) {
        lottoResultView.write("당첨 통계\n---------\n" + lottoService.lottoResult(lotteries,winningNumbers,buyAmount));
    }
}
