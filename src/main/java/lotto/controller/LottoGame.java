package lotto.controller;

import lotto.domain.*;
import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;
import lotto.util.ProfitCalculator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final PayAmount payAmount;
    private final Lottos lottos;

    public LottoGame(PayAmount payAmount, Lottos lottos){
        this.payAmount = payAmount;
        this.lottos = lottos;
    }

    public static LottoGame of(int inputPayAmount){
        PayAmount payAmount = new PayAmount(inputPayAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payAmount.lottoAmount(); i++) {
            Lotto lotto = Lotto.of(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
        return new LottoGame(payAmount, new Lottos(lottos));
    }

    public void printLottoAmount() {
        OutputView.printLottoAmount(payAmount.lottoAmount());
    }

    public void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto);
        }
    }

    public void start(List<Integer> winningNumbers, int bonusBall) {
        validateDuplicateBonusBall(winningNumbers, bonusBall);
        LottoResult lottoResult = lottos.findWinner(Lotto.of(winningNumbers), new LottoNumber(bonusBall));
        double profitRatio = ProfitCalculator.calculateProfitRatio(lottoResult, lottos.getLottos().size());
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