package camp.nextstep.edu.step3;

public class LottoService {
    private final Presenter presenter;
    private final LottoVendingMachine machine;

    public LottoService(Presenter presenter) {
        this.presenter = presenter;
        this.machine = new LottoVendingMachine(new LottoGenerator());
    }

    public void task() {
        final LottoMoney purchaseAmount = presenter.askPurchaseAmount();
        final LottoPaper lottoPaper = machine.issued(purchaseAmount);
        presenter.printLottoList(lottoPaper);
        final LottoResult winningResult = lottoPaper.checkAll(new LottoAnswer(presenter.askLastWeekWinningNumber(),  presenter.askLottoBonusNumber()));
        presenter.printResult(winningResult, winningResult.earningRate(purchaseAmount));
    }
}
