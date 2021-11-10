package lotto;

import java.util.function.Supplier;

import lotto.model.LottoMatcher;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoNumbers;
import lotto.model.MatchResult;
import lotto.model.Number;
import lotto.model.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private LottoGame() {
    }

    public static void start() {
        Payment payment = handleException(InputView::readPayment);
        OutputView.printLottoPurchase(new LottoNumberGenerator(payment).generate());
        LottoNumbers winningNumbers = handleException(InputView::readWinningNumbers);
        LottoMatcher lottoMatcher = handleException(() -> {
            Number bonusNumber = InputView.readBonusNumber();
            return new LottoMatcher(bonusNumber, winningNumbers);
        });
        MatchResult matchResult = lottoMatcher.match(payment, new LottoNumberGenerator(payment).generate());
        OutputView.printLottoResult(matchResult);
    }

    private static <T> T handleException(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            return handleException(supplier);
        }
    }
}
