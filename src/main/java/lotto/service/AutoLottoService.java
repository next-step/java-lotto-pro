package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.ResultView;

public class AutoLottoService {

    public void autoLottoService() {
        Payment payment = new Payment(InputView.printConsoleMsg(Messages.ASK_PAYMENT));
        Lottos lottos = new Lottos(payment.getPurchasedLottoCnt());
        ResultView.printPurchasedLottoCnt(lottos);
        ResultView.printGeneratedLotto(lottos);
        String winNumbers = InputView.printConsoleMsg(Messages.ASK_LAST_WIN_LOTTO_NUMBERS);
        String bonusBall = InputView.printConsoleMsg(Messages.ASK_BONUS_NUMBERS);
        WinLotto winLotto = new WinLotto(winNumbers, bonusBall);
        Statistics statistics = new Statistics(lottos, winLotto);
        ResultView.printTotalResult(payment, statistics);
    }

}
