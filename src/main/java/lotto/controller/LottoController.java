package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void playLotto() {
        OutputView.startLottoOutput();
        Lotto lotto = new Lotto(InputView.startLottoInput());
        OutputView.printString(lotto.getTicketsSizeStr());
        
        OutputView.printString(lotto.getLottoListStr());
        OutputView.printWinningLottoNumOutput();
        
        String winningTicketStr = InputView.getWinningLottoNumInput();
        OutputView.printString(lotto.getResultStr(winningTicketStr));
    }
}
