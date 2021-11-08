package lotto;

import java.util.Collection;

import lotto.model.LottoMatcher;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoNumbers;
import lotto.model.MatchResult;
import lotto.model.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private LottoGame() {
    }

    public static void start() {
        Payment payment = InputView.readPaymentHandlingException();
        Collection<LottoNumbers> lottoNumbersCollection =
            new LottoNumberGenerator(payment).generateLottoNumbersCollection();
        OutputView.printLottoPurchase(lottoNumbersCollection);
        LottoNumbers winningNumbers = InputView.readWinningNumbersHandlingException();
        MatchResult matchResult = new LottoMatcher(winningNumbers).match(payment, lottoNumbersCollection);
        OutputView.printLottoResult(matchResult);
    }
}
