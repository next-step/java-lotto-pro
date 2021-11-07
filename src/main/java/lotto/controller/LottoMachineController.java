package lotto.controller;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.exception.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        Money money = new Money(getUserInputPurchaseAmount());
        List<List<Integer>> activeNumber = getUserInputActiveNumber();

        List<LottoNumber> lottoList = lottoMachine.getLottoList(money, activeNumber);
        printPurchaseLottoList(lottoList, activeNumber.size());

        List<Number> matchNumber = getUserInputMatchNumber();
        Number bonusNumber = Number.of(inputView.getUserInputBonusNumber());

        LottoResult matchLottoResultResult = new WinningLotto(matchNumber, bonusNumber).getLottoMatchResult(lottoList);

        printMatchResult(matchLottoResultResult);

    }

    private BigDecimal getUserInputPurchaseAmount() {
        return BigDecimal.valueOf(inputView.getUserInputPurchaseAmount());
    }

    private List<Number> getUserInputMatchNumber() {
        return inputView.getUserInputMatchNumber()
                .stream()
                .map(m -> Number.of(m))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> getUserInputActiveNumber() {
        List<List<Integer>> activeNumbers = inputView.getUserInputActiveNumbers();
        return activeNumbers;
    }

    private void printMatchResult(LottoResult matchLottoResultList) {
        outputView.printPrizeLotto(matchLottoResultList);
    }

    private void printPurchaseLottoList(List<LottoNumber> lottoList, int size) {
        outputView.printPurchaseLottoList(lottoList, size);
    }

}
