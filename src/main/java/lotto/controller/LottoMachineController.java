package lotto.controller;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Money money = new Money(getUserInputPurchaseAmount());
        List<List<Number>> activeNumber = getUserInputActiveNumber();

        LottoMachine lottoMachine = new LottoMachine(money, activeNumber);

        List<LottoNumber> lottoList = lottoMachine.getLottoList();
        printPurchaseLottoList(lottoList, activeNumber.size());

        List<Number> matchNumber = getUserInputMatchNumber();
        Number bonusNumber = Number.of(inputView.getUserInputBonusNumber());

        LottoResult matchLottoResultResult = new WinningLotto(matchNumber, bonusNumber).getLottoMatchResult(lottoList);

        printMatchResult(matchLottoResultResult);
    }

    private int getUserInputPurchaseAmount() {
        return inputView.getUserInputPurchaseAmount();
    }

    private List<Number> getUserInputMatchNumber() {
        return inputView.getUserInputMatchNumber()
                .stream()
                .map(m -> Number.of(m))
                .collect(Collectors.toList());
    }

    private List<List<Number>> getUserInputActiveNumber() {
        List<List<Integer>> activeNumbers = inputView.getUserInputActiveNumbers();
        return activeNumbers.stream()
                .map(m -> m.stream()
                        .map(s -> Number.of(s))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private void printMatchResult(LottoResult matchLottoResultList) {
        outputView.printPrizeLotto(matchLottoResultList);
    }

    private void printPurchaseLottoList(List<LottoNumber> lottoList, int size) {
        outputView.printPurchaseLottoList(lottoList, size);
    }

}
