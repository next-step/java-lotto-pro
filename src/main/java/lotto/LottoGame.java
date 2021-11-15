package lotto;

import java.util.function.Supplier;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoGenerator;
import lotto.model.LottoMatcher;
import lotto.model.Lottos;
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
        LottoCount lottoCount = handleException(() -> InputView.readLottoCount(payment));
        Lottos manualLottos = handleException(() -> InputView.readManualLottos(lottoCount.getManualCount()));
        Lottos autoLottos = LottoGenerator.generate(lottoCount.getAutoCount());
        Lottos totalLottos = manualLottos.combine(autoLottos);
        OutputView.printLottoPurchase(totalLottos, lottoCount);
        Lotto winningLotto = handleException(InputView::readWinningLotto);
        LottoMatcher lottoMatcher = handleException(() -> {
            Number bonusNumber = InputView.readBonusNumber();
            return new LottoMatcher(bonusNumber, winningLotto);
        });
        MatchResult matchResult = lottoMatcher.match(payment, totalLottos);
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
