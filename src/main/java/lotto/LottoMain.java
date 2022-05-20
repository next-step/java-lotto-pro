package lotto;

import static java.lang.Integer.parseInt;

import lotto.domain.LottoMachine;
import lotto.domain.LottoWinStatistics;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningNumbers;

public class LottoMain {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();
        final PurchaseLottos purchaseLottos = purchase(inputView, resultView);
        drawingOfLots(purchaseLottos, inputView, resultView);
    }

    private static PurchaseLottos purchase(final InputView inputView, final ResultView resultView) {
        final PurchaseLottos purchaseLottos = LottoMachine.purchase(mapToInputPurchase(inputView));
        resultView.purchase(purchaseLottos);
        return purchaseLottos;
    }

    private static InputPurchaseDto mapToInputPurchase(final InputView inputView) {
        return InputPurchaseDto.of(inputView.inputPurchase(),
                inputView.inputManualNumbers(parseInt(inputView.inputManualCount())));
    }

    private static void drawingOfLots(final PurchaseLottos purchaseLottos, final InputView inputView,
                                      final ResultView resultView) {
        final WinningNumbers winningNumbers = LottoMachine.winningLottoNumbers(mapToInputWinningNumbers(inputView));
        resultView.drawingOfLots(
                new LottoWinStatistics(purchaseLottos.purchasePrice(), purchaseLottos.draw(winningNumbers)));
    }

    private static InputWinningNumbersDto mapToInputWinningNumbers(final InputView inputView) {
        return InputWinningNumbersDto.of(inputView.inputDrawingOfLots(),
                inputView.inputBonusNumber());
    }
}
