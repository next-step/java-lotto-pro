package lotto.controller;

import lotto.domain.AutoGeneratePolicy;
import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoGroups;
import lotto.domain.ManualGeneratePolicy;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGame lottoGame;

    private Money money;
    private LottoCount manualLottoCount;
    private LottoCount autoLottoCount;

    public LottoGameController() {
        setMoney();
        setLottoCount();
        lottoGame = new LottoGame(setLottoGroups(), money, manualLottoCount);
    }

    public void playGame() {
        lottoGame.playGame();
    }

    private void setMoney() {
        String inputMoney = InputView.inputMoney();
        money = new Money(inputMoney);
        InputView.printLine();
    }

    private void setLottoCount() {
        manualLottoCount = LottoCount.createValidLottoCount(InputView.inputManualLottoCount(), money);
        autoLottoCount = LottoCount.from(manualLottoCount.calculateAutoLottoCount(money));
        InputView.printLine();
    }

    private LottoGroups setLottoGroups() {
        LottoGroups lottoGroups = new LottoGroups();
        lottoGroups.generateLottoGroupsByPolicy(new ManualGeneratePolicy(), manualLottoCount);
        lottoGroups.generateLottoGroupsByPolicy(new AutoGeneratePolicy(), autoLottoCount);
        InputView.printLine();
        return lottoGroups;
    }
}
