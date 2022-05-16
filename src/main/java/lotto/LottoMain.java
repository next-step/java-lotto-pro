package lotto;

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
        final LottoNumbers winningNumbers = LottoMachine.winningLottoNumbers(inputView.inputDrawingOfLots());
        resultView.drawingOfLots(
                new LottoWinStatistics(lottos.purchasePrice(), lottos.end(winningNumbers)));
    }
}
