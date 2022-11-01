package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.ResultView;

public class AutoLottoService {

    public void autoLottoService() {
        Payment payment = new Payment(InputView.printConsoleMsg(Messages.ASK_PAYMENT));
        Lottos lottos = new Lottos(payment);
        ResultView.printPurchasedlottoCnt(lottos);
        ResultView.printGeneratedLotto(lottos);
        Lotto winLotto = new Lotto(InputView.printConsoleMsg(Messages.ASK_LAST_WIN_LOTTO_NUMBERS));
        Statistics statistics = new Statistics(lottos, winLotto);
        ResultView.printTotalResult(payment, statistics);
    }

}
