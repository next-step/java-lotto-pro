package lotto;

public class LottoMain {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();
        final LottoMachine lottoMachine = purchase(inputView, resultView);
        drawingOfLots(lottoMachine, inputView, resultView);
    }

    private static LottoMachine purchase(final InputView inputView, final ResultView resultView) {
        inputView.purchase();
        final LottoMachine lottoMachine = new LottoMachine(inputView.getPurchaseMoneyAmount());
        resultView.purchase(lottoMachine.round());
        return lottoMachine;
    }

    private static void drawingOfLots(final LottoMachine lottoMachine, final InputView inputView,
                                      final ResultView resultView) {
        inputView.drawingOfLots();
        lottoMachine.end(inputView.getWinningNumber());
        resultView.drawingOfLots(lottoMachine.round());
    }
}
