package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.MatchResult;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachineController {

    private InputView inputView;
    private OutputView outputView;

    public LottoMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Lotto lotto = new Lotto(getUserInputPurchaseAmount());
        printPurchaseLottoList(lotto);

        List<Number> userInputMatchNumber = getUserInputMatchNumber();
        MatchResult matchResult = lotto.getMatchResult(new LottoNumber(userInputMatchNumber));

        printMatchResult(matchResult);
    }

    private int getUserInputPurchaseAmount() {
        int purchaseAmount = inputView.getUserInputPurchaseAmount();
        return purchaseAmount;
    }

    private void printPurchaseLottoList(Lotto lotto) {
        outputView.printPurchaseLottoList(lotto);
    }

    private List<Number> getUserInputMatchNumber() {
        return inputView.getUserInputMatchNumber();
    }

    private void printMatchResult(MatchResult matchResult) {
        outputView.printPrizeLotto(matchResult);
    }

}
