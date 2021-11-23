package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        inputView.printPriceMessage();
        Price price = getPrice();
        Lottos lottos = new Lottos(price);
        outputView.printLottos(lottos);
        inputView.printWinningLottoMessage();
        WinningLotto winningLotto = getWinningLotto();
        inputView.printBonusNumberMessage();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
        WinningStats winningStats = new WinningStats(lottos, winningLotto, bonusNumber);
        ProfitRate profitRate = price.getProfitRate(winningStats);
        outputView.printWinningStats(winningStats);
        outputView.printProfitRate(profitRate);
    }

    private Price getPrice() {
        try {
            return new Price(inputView.inputNumber());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getPrice();
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            return new WinningLotto(inputView.inputWinningLotto());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(Lotto winningLotto) {
        try {
            return new BonusNumber(inputView.inputNumber(), winningLotto);
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getBonusNumber(winningLotto);
        }
    }
}
