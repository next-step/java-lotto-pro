package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void playLotto() {
        OutputView.startLottoOutput();
        Lotto lotto = new Lotto(InputView.startLottoInput());
        OutputView.printStr(lotto.getTicketListSizeStr());
        
        OutputView.printStr(lotto.getLottoListStr());
        OutputView.getWinningLottoNumOutput();
        
        String winningTicketStr = InputView.getWinningLottoNumInput();
        OutputView.printStr(lotto.getResultStr(winningTicketStr));
    }
}
