package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachineService {

    private InputView inputView;
    private OutputView outputView;

    public LottoMachineService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Lotto lotto = purchaseResult();

        List<Number> matchNumbers = getUserInputMatchNumbers();

        matchResult(lotto, matchNumbers);
    }

    private Lotto purchaseResult() {
        int purchaseAmount = getUserInputPurchaseAmount();
        Lotto lotto = new Lotto(purchaseAmount);
        printPurchaseLottoList(lotto);
        return lotto;
    }

    private void matchResult(Lotto lotto, List<Number> matchNumbers) {
        LottoMatch lottoMatch = new LottoMatch(matchNumbers, lotto);
        printPrizeLotto(lottoMatch);
    }

    private void printPrizeLotto(LottoMatch lottoMatch) {
        outputView.printPrizeLotto(lottoMatch);
    }

    private void printPurchaseLottoList(Lotto lotto) {
        outputView.printPurchaseLottoList(lotto);
    }

    private int getUserInputPurchaseAmount() {
        int purchaseAmount = inputView.getUserInputPurchaseAmount();
        return purchaseAmount;
    }

    private List<Number> getUserInputMatchNumbers() {
        return inputView.getUserInputMatchNumber();
    }



}
