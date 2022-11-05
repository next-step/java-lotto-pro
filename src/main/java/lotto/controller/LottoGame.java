package lotto.controller;

import lotto.domain.*;
import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;
import lotto.util.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final Lottos lottos;

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public static LottoGame of(int inputPayAmount, int userWrittenLottoAmount) {
        PayAmount payAmount = new PayAmount(inputPayAmount);
        InputValidator.validateUserWrittenLottoAmount(payAmount.totalLottoAmount(), userWrittenLottoAmount);
        return new LottoGame(new Lottos(createLottos(userWrittenLottoAmount
                , payAmount.totalLottoAmount() - userWrittenLottoAmount)));
    }

    private static List<Lotto> createLottos(int userWrittenLottoAmount, int autoLottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        addUserWrittenLottos(lottos, userWrittenLottoAmount);
        OutputView.printLottoAmount(userWrittenLottoAmount, autoLottoAmount);
        addAutoLottos(lottos, autoLottoAmount);
        return lottos;
    }

    private static void addUserWrittenLottos(List<Lotto> lottos, int userWrittenLottoAmount) {
        OutputView.printUserWrittenLotto(userWrittenLottoAmount);
        for (int i = 0; i < userWrittenLottoAmount; i++) {
            Lotto lotto = Lotto.of(InputView.inputLottoNumbers());
            lottos.add(lotto);
        }
    }

    private static void addAutoLottos(List<Lotto> lottos, int autoLottoAmount) {
        for (int i = 0; i < autoLottoAmount; i++) {
            Lotto lotto = Lotto.of(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
    }

    public void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto);
        }
    }

    public void start(List<Integer> winningNumbers, int bonusBall) {
        InputValidator.validateDuplicateBonusBall(winningNumbers, bonusBall);
        LottoResult lottoResult = lottos.findWinner(Lotto.of(winningNumbers), LottoNumber.of(bonusBall));
        BigDecimal profitRatio = ProfitCalculator.calculateProfitRatio(lottoResult, lottos.getLottos().size());
        OutputView.printLottoResult(lottoResult, profitRatio);
    }
}