package lotto_auto.controller;

import lotto_auto.model.*;
import lotto_auto.view.Output;
import lotto_auto.view.UserInputView;

public class GameController {
    public void run() {
        UserInputView userInputView = new UserInputView();
        Money money = userInputView.getMoney();
        PurchaseInfo purchaseInfo = userInputView.getPurchasedInfo(money);

        Lottos manualLottos = userInputView.getManualLottos(purchaseInfo.getManualLottoCount());
        Lottos purchasedLottos = LottoGenerator.buyLottos(purchaseInfo, manualLottos);
        Output.showPurchasedLottos(purchasedLottos);

        WinningLotto winingLotto = userInputView.getWinningLotto();

        Figures figures = purchasedLottos.matchedLottos(winingLotto);
        Output.showFigures(figures);

        ProfitRate rate = new ProfitRate(money, figures.getTotalWinning());
        Output.showProfitRate(rate);

        userInputView.closeUserInput();
    }
}
