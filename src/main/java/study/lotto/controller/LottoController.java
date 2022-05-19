package study.lotto.controller;

import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lottos;
import study.lotto.domain.draw.DrawResult;
import study.lotto.domain.draw.LottoDraw;
import study.lotto.domain.lottomachine.LottoMachine;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;
import study.lotto.domain.draw.WinningStatistics;
import study.lotto.domain.lottomachine.Price;
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
        view.showWinningStatictics(new WinningStatistics(drawResult, lottoPurchaseHistory.getTotalCost()));
    }

    private DrawResult draw(Lottos purchasedLotto) {
        LottoDraw lottoDraw = new LottoDraw(view.getWinningLotto(), view.getBonusBall().get());
        return lottoDraw.match(purchasedLotto);
    }

    private LottoPurchaseHistory purchaseLotto() {
        LottoMachine machine = getLottoMachine();
        Price purchasePrice = view.getPurchasePrice();
        Lottos manuals = view.getManualLottos();
        return machine.issueLotto(purchasePrice);
    }

    private LottoMachine getLottoMachine() {
        return new LottoMachine(new AutomaticLottoGenerator());
    }

    private void showPurchaseResult(Lottos purchasedLottos) {
        view.showPurchaseResult(purchasedLottos);
    }
}
