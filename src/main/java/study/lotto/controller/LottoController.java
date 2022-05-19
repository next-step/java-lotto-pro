package study.lotto.controller;

import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;
import study.lotto.domain.draw.DrawResult;
import study.lotto.domain.draw.LottoDraw;
import study.lotto.domain.lottomachine.LottoMachine;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;
import study.lotto.dto.PurchasedLottos;
import study.lotto.dto.WinningStatistics;
import study.lotto.view.LottoView;

public class LottoController {
    private final LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void start() {
        LottoPurchaseHistory lottoPurchaseHistory = purchaseLotto();
        Lottos purchasedLotto = lottoPurchaseHistory.getLottos();
        showPurchaseResult(purchasedLotto);

        DrawResult drawResult = draw(purchasedLotto);
        showResult(drawResult, lottoPurchaseHistory);
    }

    private void showResult(DrawResult drawResult, LottoPurchaseHistory lottoPurchaseHistory) {
        view.showWinningStatictics(WinningStatistics.of(drawResult, lottoPurchaseHistory.getTotalCost()));
    }

    private DrawResult draw(Lottos purchasedLotto) {
        Lotto winningLotto = Lotto.from(view.getWinningLottoNumbers().get());
        LottoDraw lottoDraw = new LottoDraw(winningLotto, view.getBonusBall().get());
        return lottoDraw.match(purchasedLotto);
    }

    private LottoPurchaseHistory purchaseLotto() {
        LottoMachine machine = getLottoMachine();
        return machine.issueLotto(view.getPurchasePrice());
    }

    private LottoMachine getLottoMachine() {
        return new LottoMachine(new AutomaticLottoGenerator());
    }

    private void showPurchaseResult(Lottos purchasedLottos) {
        view.showPurchaseResult(PurchasedLottos.from(purchasedLottos.get()));
    }
}
