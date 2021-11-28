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
        inputView.printManualLottoMessage();
        ManualLottos manualLottos = getManualLottos(price);
        inputView.printManualLottoNumberMessage();
        setManualLottos(manualLottos);
        Lottos lottos = new Lottos(price, manualLottos);
        outputView.printLottos(manualLottos, lottos);
        inputView.printWinningLottoMessage();
        WinningLotto winningLotto = getWinningLotto();
        inputView.printBonusNumberMessage();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);
        WinningStats winningStats = new WinningStats(manualLottos, lottos, winningLotto, bonusNumber);
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

    private ManualLottos getManualLottos(Price price) {
        try {
           return new ManualLottos(price, inputView.inputNumber());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getManualLottos(price);
        }
    }

    private void setManualLottos(ManualLottos manualLottos) {
        for (int i = 0; i < manualLottos.getSize(); i++) {
            addManualLotto(manualLottos);
        }
    }

    private void addManualLotto(ManualLottos manualLottos) {
        try {
            manualLottos.addLotto(inputView.inputLotto());
        } catch (Exception e) {
            inputView.printErrorMessage();
            addManualLotto(manualLottos);
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            return new WinningLotto(inputView.inputLotto());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        try {
            return new BonusNumber(inputView.inputNumber(), winningLotto);
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getBonusNumber(winningLotto);
        }
    }
}
