package lotto.service;

import lotto.domain.*;
import lotto.util.Common;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.ResultView;

import java.util.List;

public class AutoLottoService {

    public void autoLottoService() {
        Payment payment = getPayment();
        Lottos lottos = purchaseLotto(payment);
        Lotto winLotto = new Lotto(InputView.printConsoleMsg(Messages.ASK_LAST_WIN_LOTTO_NUMBERS));
        LottoNumber bonusBall = new LottoNumber(InputView.printConsoleMsg(Messages.ASK_BONUS_NUMBERS));
        Statistics statistics = new Statistics(lottos, winLotto, bonusBall);
        ResultView.printTotalResult(payment, statistics);
    }

    private Payment getPayment() {
        return new Payment(InputView.printConsoleMsg(Messages.ASK_PAYMENT));
    }

    private Lottos purchaseLotto(Payment payment) {

        Lottos lottos = new Lottos();
        int manualLottoCnt = Common.validateNumberType(InputView.printConsoleMsg(Messages.ASK_MANUAL_lOTTO_CNT));
        int autoLottoCnt = payment.getAutoLottoCnt(manualLottoCnt);

        List<String> manualLottos = InputView.getManualLottos(manualLottoCnt);
        manualLottos.stream().forEach(s -> lottos.addManualLotto(new Lotto(s)));
        lottos.genAutoLotto(autoLottoCnt);
        ResultView.printPurchasedLottoCnt(manualLottoCnt, autoLottoCnt);
        ResultView.printGeneratedLotto(lottos);

        return lottos;
    }
    
}
