package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoLine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.exception.LottoCountException;
import lotto.exception.LottoPaymentException;
import lotto.exception.LottoStringFormatException;
import lotto.util.LottoStringGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        LottoPayment lottoPayment = inputLottoPayment();

        LottoCount manualLottoCount = getManualLottoCount(lottoPayment);
        LottoGame manualLottoGame = getManualLottoGame(manualLottoCount);

        LottoGame autoLottoGame = buyAutoLotto(lottoPayment, manualLottoCount);
        LottoGame joinedLottoGame = LottoGame.joinLottoGame(manualLottoGame, autoLottoGame);
        outputView.printPayment(joinedLottoGame, manualLottoCount);

        LottoLine winLottoLine = inputLastWeekWinningLottoLine();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        printResult(joinedLottoGame, winLottoLine, lottoPayment, bonusNumber);
    }

    private LottoPayment inputLottoPayment() {
        try {
            return new LottoPayment(InputView.inputTotalPayment());
        } catch (LottoPaymentException e) {
            System.out.println(e.getMessage());
            return inputLottoPayment();
        }
    }

    private LottoCount getManualLottoCount(LottoPayment lottoPayment) {
        try {
            LottoCount manualLottoCount = new LottoCount(InputView.inputManualCount());
            lottoPayment.validateManualLottoCount(manualLottoCount);
            return manualLottoCount;
        } catch (LottoCountException e) {
            System.out.println(e.getMessage());
            return getManualLottoCount(lottoPayment);
        }
    }

    private LottoGame getManualLottoGame(LottoCount manualLottoCount) {
        try {
            InputView.inputManualLottoLines();
            LottoGame manualLottoGame = LottoGame.generateManualLottoGame(manualLottoCount);
            return manualLottoGame;
        } catch (LottoStringFormatException e) {
            System.out.println(e.getMessage());
            return getManualLottoGame(manualLottoCount);
        }
    }

    private LottoGame buyAutoLotto(LottoPayment lottoPayment, LottoCount manualLottoCount) {
        return LottoGame.issueLotto(lottoPayment.countLine(),
            manualLottoCount.value());
    }

    private LottoLine inputLastWeekWinningLottoLine() {
        try {
            return LottoStringGenerator.toLottoLine(InputView.inputLastWeekWinningLottoLine());
        } catch (LottoStringFormatException e) {
            System.out.println(e.getMessage());
            return inputLastWeekWinningLottoLine();
        }
    }

    private void printResult(LottoGame lottoGame, LottoLine winLottoLine, LottoPayment lottoPayment,
        LottoNumber bonusNumber) {
        LottoResult lottoResult = lottoGame.getLottoResult(winLottoLine, bonusNumber);
        LottoPayment prize = new LottoPayment(lottoResult.getLottoPrize());
        outputView.printLottoResult(outputView.getLottoResultString(lottoResult));
        outputView.printEarningRate(
            outputView.getEarningRateString(lottoPayment, prize)
        );
    }
}
