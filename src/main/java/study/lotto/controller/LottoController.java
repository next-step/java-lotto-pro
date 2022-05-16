package study.lotto.controller;

import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.draw.DrawResult;
import study.lotto.domain.draw.LottoDraw;
import study.lotto.domain.lottomachine.LottoMachine;
import study.lotto.domain.lottomachine.LottoPrice;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;
import study.lotto.dto.BonusBall;
import study.lotto.dto.PurchasedLottos;
import study.lotto.dto.WinningLottoNumbers;
import study.lotto.dto.WinningStatistics;
import study.lotto.view.LottoView;

public class LottoController {
    private final LottoView view;

    public LottoController(LottoView view) {
        this.view = view;
    }

    public void start() {
        LottoPurchaseHistory lottoPurchaseHistory = purchaseLotto();
        DrawResult drawResult = draw(lottoPurchaseHistory);
        showResult(lottoPurchaseHistory, drawResult);
    }

    private void showResult(LottoPurchaseHistory lottoPurchaseHistory, DrawResult drawResult) {
        WinningStatistics winningStatistics = WinningStatistics.of(drawResult, lottoPurchaseHistory.getTotalPrice());
        view.showWinningStatictics(winningStatistics);
    }

    private DrawResult draw(LottoPurchaseHistory lottoPurchaseHistory) {
        WinningLottoNumbers winningLottoNumbers = view.getWinningLottoNumbers();
        BonusBall bonusBall = view.getBonusBall();

        LottoDraw lottoDraw = new LottoDraw(winningLottoNumbers.getLottoNumbers());
        DrawResult drawResult = lottoDraw.match(lottoPurchaseHistory.getLottos());
        return drawResult;
    }

    private LottoPurchaseHistory purchaseLotto() {
        LottoMachine machine = new LottoMachine(new AutomaticLottoGenerator(), new LottoPrice());
        LottoPurchaseHistory lottoPurchaseHistory = machine.issueLotto(view.getPurchasePrice().value());
        view.showPurchaseResult(PurchasedLottos.from(lottoPurchaseHistory.getLottos().lottoNumbers()));
        return lottoPurchaseHistory;
    }
}
