package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoGenerator;
import lotto.util.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        try {
            LottoAmount lottoAmount = getLottoAmount();
            Lottos lottos = generateLottos(lottoAmount);
            printLottos(lottos);
            LottoResult lottoResult = lottos.findWinner(Lotto.from(InputView.inputLottoWinningNumbers())
                    , LottoNumber.from(InputView.inputBonusBall()));
            OutputView.printLottoResult(lottoResult,
                    ProfitCalculator.calculateProfitRatio(lottoResult, lottos.getLottos().size()));
        } catch (Exception e) {
            System.out.println("프로그램 종료." + e.getMessage());
        }
    }

    private LottoAmount getLottoAmount() {
        return LottoAmount.of(new PayAmount(InputView.inputPayAmount()).totalLottoAmount(), InputView.inputUserWrittenLottoCount());
    }

    private Lottos generateLottos(LottoAmount lottoAmount) {
        Lottos userWrittenLottos = LottoGenerator.createUserWrittenLottos(
                InputView.inputUserWrittenLottoNumbers(lottoAmount.getUserWrittenLottoAmount()));
        Lottos autoWrittenLottos = LottoGenerator.createAutoLottos(lottoAmount.getAutoLottoAmount());
        OutputView.printLottoAmount(lottoAmount.getUserWrittenLottoAmount(), lottoAmount.getAutoLottoAmount());
        return autoWrittenLottos.addAll(userWrittenLottos);
    }

    private void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto);
        }
    }
}