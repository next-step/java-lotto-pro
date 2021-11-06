package lotto.controller;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachineController {

    private InputView inputView;
    private OutputView outputView;
    private LottoMachine lottoMachine;

    public LottoMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        List<LottoNumber> lottoList = lottoMachine.getLottoList(new Money(getUserInputPurchaseAmount()));
        printPurchaseLottoList(lottoList);

        List<Number> matchNumber = getUserInputMatchNumber();
        Number bonusNumber = new Number(inputView.getUserInputBonusNumber());

        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult matchLottoResultResult = winningLotto.getLottoMatchResult(lottoList);

        printMatchResult(matchLottoResultResult);
    }

    private int getUserInputPurchaseAmount() {
        return inputView.getUserInputPurchaseAmount();
    }

    private void printPurchaseLottoList(List<LottoNumber> lottoList) {
        outputView.printPurchaseLottoList(lottoList);
    }

    private List<Number> getUserInputMatchNumber() {
        return inputView.getUserInputMatchNumber()
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void printMatchResult(LottoResult matchLottoResultList) {
        outputView.printPrizeLotto(matchLottoResultList);
    }


}
