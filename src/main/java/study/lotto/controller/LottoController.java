package study.lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.Lottos;
import study.lotto.domain.draw.DrawResult;
import study.lotto.domain.draw.LottoDraw;
import study.lotto.domain.lottomachine.LottoMachine;
import study.lotto.domain.lottomachine.LottoPrice;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;
import study.lotto.dto.BonusBall;
import study.lotto.dto.PurchasePrice;
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
        Lottos purchasedLotto = lottoPurchaseHistory.getLottos();
        showPurchaseResult(purchasedLotto);

        DrawResult drawResult = draw(purchasedLotto);
        showResult(drawResult, lottoPurchaseHistory);
    }

    private void showResult(DrawResult drawResult, LottoPurchaseHistory lottoPurchaseHistory) {
        view.showWinningStatictics(WinningStatistics.of(drawResult, lottoPurchaseHistory.getTotalCost()));
    }

    private DrawResult draw(Lottos purchasedLotto) {
        WinningLottoNumbers winningLottoNumbers = view.getWinningLottoNumbers();
        BonusBall bonusBall = view.getBonusBall();
        Lotto winningLotto = new Lotto(convertToLottoNumbers(winningLottoNumbers));

        LottoDraw lottoDraw = new LottoDraw(winningLotto, bonusBall.get());
        return lottoDraw.match(purchasedLotto);
    }

    private LottoPurchaseHistory purchaseLotto() {
        PurchasePrice purchasePrice = view.getPurchasePrice();

        LottoMachine machine = getLottoMachine();
        return machine.issueLotto(purchasePrice.get());
    }

    private LottoMachine getLottoMachine() {
        return new LottoMachine(new AutomaticLottoGenerator(), new LottoPrice());
    }

    private void showPurchaseResult(Lottos purchasedLottos) {
        view.showPurchaseResult(PurchasedLottos.from(purchasedLottos.get()));
    }

    private List<LottoNumber> convertToLottoNumbers(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.getLottoNumbers().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
