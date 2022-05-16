package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoWinStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LottoMain {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();
        final Lottos lottos = purchase(inputView, resultView);
        drawingOfLots(lottos, inputView, resultView);
    }

    private static Lottos purchase(final InputView inputView, final ResultView resultView) {
        final Lottos lottos = LottoMachine.purchase(inputView.inputPurchase());
        resultView.purchase(lottos);
        return lottos;
    }

    private static void drawingOfLots(final Lottos lottos, final InputView inputView,
                                      final ResultView resultView) {
        final WinningNumbers winningNumbers = LottoMachine.winningLottoNumbers(inputView.inputDrawingOfLots(), inputView.inputBonusNumber());
        resultView.drawingOfLots(
                new LottoWinStatistics(lottos.purchasePrice(), lottos.draw(winningNumbers)));
    }
}
