package lotto.controller;

import lotto.domain.*;
import lotto.util.InputValidator;
import lotto.util.ProfitCalculator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final PayAmount payAmount;
    private final Lottos lottos;

    public LottoGame(int inputPayAmount) {
        payAmount = new PayAmount(inputPayAmount);
        printLottoAmount();
        lottos = new Lottos(payAmount.lottoAmount());
        printLottos();
    }

    private void printLottoAmount() {
        OutputView.printLottoAmount(payAmount.lottoAmount());
    }

    private void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto);
        }
    }

    public void start(List<Integer> winningNumbers, int bonusBall) {
        validateDuplicateBonusBall(winningNumbers, bonusBall);
        LottoResult lottoResult = lottos.findWinner(new Lotto(winningNumbers), new LottoNumber(bonusBall));
        double profitRatio = ProfitCalculator.calculateProfit(lottoResult, lottos.getLottos().size());
        printLottoResult(lottoResult, profitRatio);
    }

    public void validateDuplicateBonusBall(List<Integer> winningNumbers, int bonusBall) {
        List<Integer> lottoNumberIncludeBonusBall = new ArrayList<>(winningNumbers);
        lottoNumberIncludeBonusBall.add(bonusBall);
        InputValidator.validateDuplicateLottoNumber(lottoNumberIncludeBonusBall);
    }

    private void printLottoResult(LottoResult lottoResult, double profitRatio) {
        OutputView.printLottoResult(lottoResult, profitRatio);
    }
}