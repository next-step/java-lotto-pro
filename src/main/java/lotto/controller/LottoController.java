package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void playLotto() {
        OutputView.startLottoOutput();
        Lotto lotto = new Lotto(InputView.getInput());
        OutputView.print(lotto.getTicketsSizeStr());
        
        OutputView.print(lotto.getLottoListStr());
        
        OutputView.printWinningLottoNumOutput();
        String winningTicketStr = InputView.getInput();
        
        OutputView.printBonusNumOutput();
        String bonusNumStr = InputView.getInput();
        
        OutputView.print(lotto.getResultStr(winningTicketStr, bonusNumStr));
    }
}
